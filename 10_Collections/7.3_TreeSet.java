import java.util.*;

public class 7.3_TreeSet {
    public static void main(String[] args) {
        Set<Integer> nums = new TreeSet<>();
        nums.add(30);
        nums.add(10);
        nums.add(20);
        nums.add(10);
        nums.add(30);
        System.out.println(nums);                   // [10, 20, 30]

        // Check
        System.out.println(nums.contains(20));      // true

        // Remove
        nums.remove(20);
        System.out.println(nums);                   // [10, 30]
        
        // Size
        System.out.println(nums.size());           // 2
    }
}