import java.util.*;

public class 9.0_TreeMap {
    public static void main(String[] args) {

        TreeMap<Integer, String> students = new TreeMap<>();

        students.put(103, "Priya");
        students.put(101, "Rahul");
        students.put(102, "Amit");
        students.put(105, "Neha");

        System.out.println(students);                // {101=Rahul, 102=Amit, 103=Priya, 105=Neha}

        // Get value
        System.out.println(students.get(102));               // Amit

        // Check key
        System.out.println(students.containsKey(103));               // true

        // Remove
        students.remove(105);

        // First and last key
        System.out.println(students.firstKey());                 // 101

        System.out.println(students.lastKey());                  // 103

        System.out.println(students.lowerKey(102));             // 101


        System.out.println(students.floorKey(102));             // 102


        System.out.println(students.higherKey(102));             // 103

        System.out.println(students.ceilingKey(102));             // 102
    }
}

// lowerKey(x)
// → largest key strictly smaller than x

// floorKey(x)
// → largest key ≤ x

// higherKey(x)
// → smallest key strictly greater than x

// ceilingKey(x)
// → smallest key ≥ x