import java.util.*;

public class 7.1_LinkedHashSet {
    public static void main(String[] args) {

        Set<Integer> nums = new LinkedHashSet<>();

        nums.add(30);
        nums.add(10);
        nums.add(20);
        nums.add(10);
        nums.add(30);

        System.out.println(nums);                   // [30, 10, 20]


        // Check element
        System.out.println(nums.contains(20));     // true

        // Remove
        nums.remove(10);
        System.out.println(nums);                   // [30, 20]

        // Size
        System.out.println(nums.size());            // 2

        // Clear
        nums.clear();
        System.out.println(nums);                   // []
    }
}