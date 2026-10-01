import java.util.*;

public class 7.4_TreeSet {
    public static void main(String[] args) {
        TreeSet<Integer> nums = new TreeSet<>();
        nums.add(10);
        nums.add(20);
        nums.add(30);
        nums.add(40);
        nums.add(50);

        System.out.println(nums.first());    // 10
        System.out.println(nums.last());     // 50

        System.out.println(nums.lower(30));  // 20
        System.out.println(nums.higher(30)); // 40

        System.out.println(nums.floor(35));  // 30
        System.out.println(nums.ceiling(35)); // 40
    }
}

// lower(x)
// → strictly smaller than x

// floor(x)
// → smaller than OR equal to x

// higher(x)
// → strictly greater than x

// ceiling(x)
// → greater than OR equal to x