import java.util.*;

public class 7.0_HashSet {
    public static void main(String[] args) {

        Set<Integer> nums = new HashSet<>();

        // Add
        nums.add(10);
        nums.add(20);
        nums.add(30);
        nums.add(20);
        nums.add(10);

        System.out.println(nums);      // [10, 20, 30]  (order is not guaranteed)

        // Contains
        System.out.println(nums.contains(20));      // true

        // Remove
        nums.remove(20);
        System.out.println(nums);       // [10, 30]

        // Size
        System.out.println(nums.size());     // 2

        // Check empty
        System.out.println(nums.isEmpty());      // false

        // Clear
        nums.clear();
        System.out.println(nums);         // []
    }
}