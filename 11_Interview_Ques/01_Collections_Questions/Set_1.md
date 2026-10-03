## Q1: What happens if you change a HashMap key after putting it into the map?
A `HashMap` key should generally be **immutable**.
If a field used in `hashCode()` is changed after inserting the key:

```text
put()
 ↓
hashCode → Bucket A
 ↓
Key stored in Bucket A

Key changes
 ↓
hashCode changes → Bucket B
 ↓
get() searches Bucket B
```

But the key is still in **Bucket A**, so `get()`, `containsKey()`, or `remove()` may fail.

### Rule
> Avoid modifying fields used by `equals()` and `hashCode()` while the object is a `HashMap` key.

---

## Q2: Why can a HashMap fail even when `equals()` says two objects are equal?

`HashMap` first uses `hashCode()` to find the bucket and then uses `equals()` to find the exact key.

```text
Key
 ↓
hashCode()
 ↓
Find bucket
 ↓
equals()
 ↓
Find key
```

### Problem

If `equals()` returns `true` but the two objects have **different hash codes**, they may be placed/searched in different buckets.

```text
s1.equals(s2)  → true

s1.hashCode()  → 10
s2.hashCode()  → 20   ❌
```

`HashMap` may search a different bucket and never call `equals()`.

### Small Example

```text
class Student
    id

equals(s1, s2):
    return s1.id == s2.id

hashCode(student):
    return randomValue   // ❌ Wrong
```

```text
s1 = Student(101)
s2 = Student(101)

s1.equals(s2)     → true
s1.hashCode()     → 10
s2.hashCode()     → 20
```

This violates the `equals()` / `hashCode()` contract.

### Rule

> If `a.equals(b)` is `true`, then `a.hashCode()` **must be equal to** `b.hashCode()`.

But the reverse is **not required**:

```text
same hashCode → equals() may be true or false
```

This is called a **hash collision** when different objects have the same hash code.

---

## Q3: Can two different objects have the same hash code?

**Yes.** Two different objects can return the same hash code.

This situation is called a **hash collision**.

```text
Object A ──→ hashCode() ──→ 10
Object B ──→ hashCode() ──→ 10
```

Both keys may end up in the **same HashMap bucket**.

`HashMap` then uses `equals()` to identify the correct key.

### Small Example

```text
s1 = Student(101, "A")
s2 = Student(102, "B")

s1.hashCode() → 10
s2.hashCode() → 10

s1.equals(s2) → false
```

So:

```text
Same hashCode
     ↓
Same bucket
     ↓
equals()
     ↓
Find the correct key
```

### Important Rule

> Same hash code **does NOT mean** objects are equal.

But:

> If two objects are equal, their hash codes **must be the same**.

This is called a **hash collision**.

---

## Q4: What happens if you change an ArrayList while a for-each loop is running?

Normally, you may get a **`ConcurrentModificationException`**.

A `for-each` loop internally uses an **Iterator**.

```text id="y7x4mz"
for-each
   ↓
Iterator
   ↓
ArrayList
```

If you directly modify the list while iterating:

```text id="q5m1cs"
for (element : list) {
    list.remove(element);   // ❌
}
```

The iterator detects that the collection was structurally modified unexpectedly and may throw:

```text
ConcurrentModificationException
```

### Safe Removal

Use the **Iterator's own `remove()`** method when removing elements during iteration:

```text id="8yq1fd"
Iterator → next()
         → remove()  ✅
```

> **Rule:** Don't directly modify an `ArrayList` while iterating with a `for-each` loop. Use `Iterator.remove()` for safe removal.

---

## Q5: Why does ConcurrentHashMap not allow null keys or null values?

`ConcurrentHashMap` does **not allow `null` keys or values** mainly to avoid ambiguity in a multi-threaded environment.

Suppose:

```java
map.get(key);
```

returns `null`.

What does it mean?

```text
null
 ↓
Key does not exist?
      OR
Key exists but value is null?
```

With multiple threads, this ambiguity can make the result difficult to interpret safely.

Therefore:

> `ConcurrentHashMap` does not allow **null keys or null values**.

### Example

```java
ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

map.put(null, "A");     // ❌ NullPointerException
map.put("A", null);     // ❌ NullPointerException
```

### Key Point

```text
HashMap            → allows 1 null key + multiple null values
ConcurrentHashMap  → does NOT allow null keys or values
```

---

## Q6: If HashMap already exists, why do we need ConcurrentHashMap?

`HashMap` is **not thread-safe**. If multiple threads modify the same `HashMap` simultaneously, it can lead to inconsistent or incorrect results.

`ConcurrentHashMap` is designed for **multi-threaded environments**.

```text
HashMap
   ↓
Multiple threads modify
   ↓
❌ Not thread-safe


ConcurrentHashMap
   ↓
Multiple threads access/modify
   ↓
✅ Thread-safe
   ↓
Better concurrent performance
```

### Key Point

`ConcurrentHashMap` provides:

* **Thread safety**
* Allows multiple threads to access the map concurrently
* Avoids locking the **entire map** for every operation

> Use `HashMap` for normal single-threaded use and `ConcurrentHashMap` when multiple threads need to safely access/modify the same map.

---

## Q7: What happens if two threads update the same key in ConcurrentHashMap?

`ConcurrentHashMap` handles concurrent updates safely.

If two threads try to update the **same key** at the same time, `ConcurrentHashMap` uses internal synchronization and atomic operations to control the update.

- The internal map structure remains safe.
- No corruption occurs due to concurrent updates.
- One update will eventually be the value stored for that key.
- If both operations are simple `put()` operations, the final value depends on the ordering of the updates.

### Example

```java
ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

Thread t1 = new Thread(() -> {
    map.put(1, "A");
});

Thread t2 = new Thread(() -> {
    map.put(1, "B");
});

t1.start();
t2.start();

```

---

## Q8: Why does HashMap allow one null key but Hashtable does not?

`HashMap` has special handling for `null`, so it allows **one `null` key**.

```java
HashMap<Integer, String> map = new HashMap<>();

map.put(null, "A");
map.put(null, "B");

System.out.println(map); // {null=B}
```

The second `put()` replaces the first value because keys must be unique.

`Hashtable` is an older synchronized class and **does not allow `null` keys or values**.

```java
Hashtable<Integer, String> table = new Hashtable<>();

table.put(null, "A"); // NullPointerException
```

### Key Point

> `HashMap` allows one `null` key, while `Hashtable` does not allow `null` keys or values.

---

## Q9: What happens when many HashMap keys go into the same bucket?

This is called a **collision**.

When multiple keys map to the same bucket, `HashMap` stores multiple entries in that bucket.

* **Older Java:** Entries were mainly stored using a linked structure.
* **Java 8+:** If collisions become high enough and certain conditions are met, the bucket can be converted into a **tree structure**.
* This improves searching when many entries are present in the same bucket.

### Key Point

> Collision means multiple keys map to the same bucket. Java 8+ can convert a heavily-collided bucket into a tree to improve performance.

---

## Q9: How does HashMap actually find a value when we call `get()`?

Suppose we call:

```java
map.get(key);
```

HashMap follows these steps:

1. Calculates the **hash** of the key.
2. Uses the hash to find the **bucket**.
3. Checks the entries inside that bucket.
4. Uses **hash + `equals()`** to find the exact matching key.
5. Returns the corresponding **value**.

### Key Point

> `get()` → **hash → bucket → compare keys → return value**

---

## Q10: What exactly happens inside HashMap when we call `put()`?

Suppose we call:

```java
map.put(key, value);
```

HashMap follows these steps:

1. Calculates the **hash** of the key.
2. Finds the appropriate **bucket**.
3. If the bucket is empty → adds the entry.
4. If the bucket has entries → compares the keys.
5. If the same key exists → **updates its value**.
6. Otherwise → adds a **new entry** to the bucket.

### Key Point

> `put()` → **hash → bucket → compare keys → update or add**

---

## Q11: How does HashMap handle two keys with the same hash?

If two keys generate the **same bucket**, HashMap checks whether the keys are actually equal using `equals()`.

* **Same hash + keys equal** → value is **updated**.
* **Same hash + keys different** → both entries are stored in the **same bucket**.
* This situation is called a **collision**.

```java
map.put(key1, "A");
map.put(key2, "B");
```

If `key1` and `key2` have the same hash but are not equal, both entries can exist.

### Key Point

> Same hash does **not** mean same key. HashMap uses `equals()` to distinguish keys and handle collisions.
---

## Q12: What happens if you override `equals()` but forget `hashCode()`?

This can cause problems in **HashMap** and **HashSet**.

If two objects are equal according to `equals()`, they **must have the same `hashCode()`**.

If `hashCode()` is not overridden:

* Equal objects may get different hash codes.
* They may be placed in different buckets.
* `HashSet` may allow duplicate-looking objects.
* `HashMap` lookup may fail.

### Key Point

> If you override `equals()`, you should **always override `hashCode()`** consistently.

---

## Q13: Can we use any custom object as a HashMap key?

**Yes**, we can use a custom object as a `HashMap` key.

But we should:

* Override `equals()` and `hashCode()` properly.
* Prefer making the key object **immutable**.
* Avoid changing fields used by `equals()`/`hashCode()` after insertion.

Otherwise, `HashMap` lookup may fail.

### Key Point

> Custom objects can be HashMap keys, but `equals()` + `hashCode()` must be consistent, and immutable keys are preferred.

---

## Q14: What should we take care of when using our own class as a HashMap key?

Mainly three things.
- First, properly implement `equals()`.
- Second, properly implement `hashCode()`.
- And third, try to keep the fields used in these methods `immutable`.

> If these rules are followed, your custom object can work properly as a HashMap key.

---

## Q15: Why is String a good choice for a HashMap key?

Because `String` is `immutable`.
Once a String object is created, its value cannot be changed.
So its logical value does not suddenly change after we put it inside HashMap.

String also properly implements `equals()` and `hashCode()`.

> That makes it a safe and common choice for map keys

---

## Q16: What are capacity and load factor in HashMap?

Capacity means the number of buckets available internally.

- The default `initial capacity` of `HashMap` is generally **16**.

Load factor decides when HashMap should resize.

- The default `load factor` is **0.75**.

*So if capacity is 16, the resize threshold is normally around 12 entries.*

> When the size crosses the threshold, HashMap increases its internal capacity.

---

## Q17: Why does HashMap resize?

Because if too many entries are stored in a small number of buckets, collisions can increase.

And more collisions can reduce performance.

So when the number of entries crosses the threshold, `HashMap` creates a bigger internal table.

Then entries are moved into the new table.

Resizing helps `HashMap` maintain good performance.

> But resizing itself is an expensive operation.

---

## Q18: Why does Map not extend the Collection interface?

Because Collection mainly represents individual elements.

For example, `List` contains `elements`, `Set` contains `elements` and `Queue` contains `elements`.

But Map works differently.

`Map` stores data as `key-value` pairs.

Collection mainly uses operations like add(element).

Map uses operations like: put(key, value)

> So because their structures and operations are different, Map is kept separate from the Collection interface.

---

## Q19: Why are Map keys unique but values can be duplicate?

Because the key is used to identify the value.

Suppose two identical keys were allowed.

Then when we call get(key), Java would not know which value should be returned.

So keys must be unique.

Values are just the data associated with keys.

> So multiple keys can have the same value.

---

## Q20. Why do we normally use `entrySet()` when looping through a Map?

`entrySet()` gives us the **key and value together** as a `Map.Entry`.

```java
for (Map.Entry<Integer, String> entry : map.entrySet()) {
    System.out.println(entry.getKey());
    System.out.println(entry.getValue());
}
```

With `keySet()`, we get only the keys and need `map.get(key)` to get the value:

```java
for (Integer key : map.keySet()) {
    System.out.println(key);
    System.out.println(map.get(key));
}
```

### Key Point

> If we need **both key and value**, `entrySet()` is usually cleaner and more efficient because each entry already contains both.

---

### Q21: What is the real difference between HashMap, LinkedHashMap and TreeMap?

`HashMap` focuses mainly on fast storage and retrieval.
- It does not guarantee insertion order.

`LinkedHashMap` works like HashMap but also maintains order.
- Usually it maintains insertion order.

`TreeMap` keeps its keys sorted.

> So very simply:

> - **HashMap** — fast lookup.
> - **LinkedHashMap** — maintains order.
> - **TreeMap** — maintains sorted keys.

---

### Q22: How does LinkedHashMap remember insertion order?

`LinkedHashMap` uses `HashMap-like storage` for **fast lookup**.

But along with that, it also **maintains links between entries**.

We can think of it as `HashMap` plus a `doubly linked list`.

That linked structure remembers which entry was inserted before and which came after.

That is why iteration gives entries in insertion order.

---

## Q23: How does LinkedHashMap remember which item was used recently?

`LinkedHashMap` has an option called `access order`.

When access order is enabled, whenever we access an entry, that entry can be moved toward the end of the internal linked order.

So recently accessed items move to one side.

And older, less recently used items stay near the beginning.

> This feature is useful when building an LRU cache.

---

## Q24: Why is LinkedHashMap commonly used for an LRU cache?

LRU means Least Recently Used.

Suppose our cache has space for only 100 objects.

When the 101st object comes, we want to remove the object that has not been used for the longest time.

`LinkedHashMap` can maintain entries in access order.

So the least recently used entry can be identified easily.

> That is why `LinkedHashMap` is commonly used for **simple LRU cache implementations**.

---

## Q25: Why is LinkedHashMap slightly slower than HashMap?

Because `LinkedHashMap` has some extra work.

HashMap mainly stores and finds entries.

`LinkedHashMap` does that plus it also maintains the linked order of entries.

Whenever entries are added, removed or accessed, those links may also need to be updated.

> Because of this extra work, `LinkedHashMap` has slightly more overhead than HashMap.

---

## Q26: How does TreeMap keep keys sorted?

`TreeMap` internally uses a `self-balancing tree`.

More specifically, it uses a `Red-Black Tree`.

Whenever a new key is added, TreeMap compares it with existing keys.

Based on the comparison, it decides whether it should go to the left or right side.

> The tree also balances itself, because of this, the keys remain sorted.

---

## Q27: Why does TreeMap need Comparable or Comparator?

Because `TreeMap` has to sort the keys.

To sort something, it needs to know how two keys should be compared.

If the key class implements Comparable, TreeMap can use the natural ordering.

For example, numbers naturally sort from smaller to larger.

If we want our own sorting rule, we can provide a Comparator.

Without a valid comparison rule, TreeMap cannot properly decide the order of custom objects.

---

## Q28: What happens if a Comparator gives inconsistent results?

Then TreeMap or TreeSet may behave unexpectedly.

Remember, these collections use comparison not only for sorting, but also to decide whether two elements are considered the same for ordering purposes.

If your Comparator gives incorrect or inconsistent results, an element may appear to be missing or another element may replace it.

So Comparator logic should always be consistent.

---

## Q29: Why does TreeMap use a Red-Black Tree?

Because TreeMap needs sorted data but also needs reasonable performance.

If we use a normal binary tree, it can sometimes become completely unbalanced.

Then searching could become very slow.

A Red-Black Tree keeps itself approximately balanced.

Because of that, searching, inserting and deleting normally take around O(log n) time.

---

## Q30: Why is TreeSet usually slower than HashSet?

`HashSet` uses `hashing`.

So in normal situations, searching, adding and removing can be very fast, close to O(1) average time.

`TreeSet` keeps the elements sorted.

For every insertion or search, it has to perform comparisons inside its tree.

So these operations usually take O(log n) time.

That is why HashSet is normally faster when sorting is not required.

---

## Q31: How does HashSet know that an element is already present?

HashSet internally uses a HashMap.

When we add an object into HashSet, it uses the object's hashCode() to find the bucket.

Then it uses equals() to check whether the same object already exists.

If an equal object already exists, HashSet does not add it again.

That is how HashSet maintains uniqueness.

---

## Q32: How does LinkedHashSet keep insertion order?

LinkedHashSet gives us the uniqueness behavior of HashSet.

But it also maintains a linked structure to remember insertion order.

So when elements are added, the order is remembered.

When we iterate later, elements come in the same order in which they were inserted.

---

## Q33: Why does Set not have something like get(0)?

Because Set is not designed around positions.

A List has index positions like 0, 1, 2 and so on.

But Set mainly focuses on unique elements.

For a normal HashSet, there is no guarantee that an element is stored at a particular position.

So something like set.get(0) would not make sense.

---

## Q34: Can a Set store null values?

It depends on the Set implementation.

HashSet can store one null value.

LinkedHashSet can also store one null value.

TreeSet normally does not support null when natural ordering is being used, because null cannot be compared with other elements.

So the answer depends on which Set implementation we are using.

## Q35: How can we make a collection thread-safe?

A normal collection like `ArrayList` can throw `ConcurrentModificationException` if it is structurally modified while being iterated.

```java
List<Integer> list = new ArrayList<>();
```

`CopyOnWriteArrayList` works differently. Its iterator uses a **snapshot** of the collection.

So, changes made after the iterator is created do not affect the current iteration.

```java
CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
```

This behavior is commonly called **fail-safe** or **snapshot-based iteration**.

### Key Point

> **Fail-fast:** detects unexpected modification and may throw `ConcurrentModificationException`.
> **Snapshot-based:** iterates over a separate snapshot, so later modifications don't break the current iteration.

---

## Q36: What is the difference between fail-fast and fail-safe iteration?

A `fail-fast iterator` can throw `ConcurrentModificationException` if the collection is structurally changed unexpectedly during iteration.

*ArrayList* is a common example.

Collections such as `CopyOnWriteArrayList` behave differently.

Their iteration is based on a separate snapshot of the data.

So changes happening after the iterator was created do not break that iteration.

This is commonly described as fail-safe behavior.

---

## Q37: Why do some iterators throw ConcurrentModificationException?

Because the iterator expects the collection structure to remain consistent while it is iterating.

Suppose we are looping through an ArrayList.

At the same time, we directly add or remove an element from that list.

The iterator notices that the collection was modified outside its expected flow.

So it throws `ConcurrentModificationException`.

> This helps detect unsafe modification.

---

## Q38: Why does ConcurrentHashMap usually not throw `ConcurrentModificationException` while looping?

`ConcurrentHashMap` is designed for **concurrent access**.

One thread can iterate over the map while another thread updates it.

Its iterators are **weakly consistent**, meaning:

* They do not throw `ConcurrentModificationException` due to concurrent updates.
* They can continue while the map is being modified.
* The iterator may or may not see updates made during iteration.

```java
for (Map.Entry<Integer, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " " + entry.getValue());
}
```

### Key Point

> `ConcurrentHashMap` allows iteration and modification at the same time. Its **weakly consistent iterator** does not require the map to remain unchanged during iteration.

---

## Q39: What is the main difference between synchronizedMap() and ConcurrentHashMap?

`synchronizedMap()` uses synchronization around map operations.

This can create **more blocking** when many threads are working.

`ConcurrentHashMap` is designed specifically for **higher concurrency**.

Multiple threads can perform many operations at the same time without locking the complete map.

> So for highly concurrent applications, `ConcurrentHashMap` generally performs better.

---

### Q40: If both are thread-safe, why is ConcurrentHashMap usually faster?

Because thread safety does not always mean the same locking strategy.

With a synchronized map, threads can block each other more often.

`ConcurrentHashMap` uses a more **fine-grained** internal design.

For example, multiple reads can happen together.

And updates to unrelated locations can often happen without blocking the entire map.

> So as the number of threads increases, `ConcurrentHashMap` usually scales better.

---

## Q41: Why is Hashtable considered outdated for most new applications?

`Hashtable` is an older class.

Its methods are synchronized, so it is thread-safe.

But its synchronization is quite heavy compared with modern concurrent collections.

If **thread safety** is **not required**, `HashMap` is generally preferred.

If **thread safety** is **required**, `ConcurrentHashMap` is usually a better choice.

---

## Q42: What is CopyOnWriteArrayList and why does it create a new copy?

`CopyOnWriteArrayList` is a `thread-safe List`.

Its special behavior is that when we modify the list, such as adding or removing an element, it creates a copy of its internal array.

The modification happens on this new copy.

Readers can continue using the old array safely.

> This gives very fast reading. But writing becomes expensive because a copy has to be created.

---

## Q43: Why can CopyOnWriteArrayList be changed while another thread is reading it?

Because the reader and writer are not necessarily working on the exact same array.

Suppose one thread starts iterating.

It keeps a reference to the current internal array.

Now another thread adds an element.

CopyOnWriteArrayList creates a new array for that change.

The first thread can continue reading the old array safely.

That is why iteration does not break.

---

## Q44: When should we use CopyOnWriteArrayList instead of synchronizedList()?

Use CopyOnWriteArrayList when reads are very frequent and writes are rare.

For example, suppose we have a list of listeners or configuration items.

Thousands of reads may happen, but updates happen only occasionally.

CopyOnWriteArrayList can work very well there.

> But if you are constantly adding and removing data, it may be expensive because every write creates a copy.

---

## Q45: What is the difference between synchronized collections and concurrent collections?

Both can provide thread safety.

But the way they achieve it is different.

Synchronized collections generally use more locking around operations.

Concurrent collections are designed to allow more operations to happen at the same time.

For example, ConcurrentHashMap allows high concurrent access.

> So synchronized collections are simpler, but concurrent collections normally scale better when many threads are involved.

---

## Q46: Why can Vector still have thread-safety problems even though its methods are synchronized?

Because synchronizing individual methods does not automatically make a complete sequence of operations safe.

For example, suppose we first check the size of a Vector and then remove an element.

Between those two operations, another thread may modify the Vector.

Each individual method call is synchronized.

But the complete sequence is not necessarily atomic.

So sometimes external synchronization is still required.

---

## Q47: If you need a thread-safe collection, how do you decide which one to use?

First, understand the requirement.

If `multiple threads` are working with `key-value data` and we need good performance, `ConcurrentHashMap` is usually a good option.

If we already have a normal collection and just need **basic synchronization**, `synchronized wrapper`s can be used.

If we have a List where reads are very high and updates are very rare, `CopyOnWriteArrayList` can be a good option.

> So don't choose a collection only because it is thread-safe. Choose it based on how much reading, writing and concurrency our application actually has

---