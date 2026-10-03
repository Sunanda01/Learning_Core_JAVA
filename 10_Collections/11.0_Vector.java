import java.util.*;

public class 11.0_Vector {
    public static void main(String[] args) {
        Vector<Integer> nums = new Vector<>();

        // Add
        nums.add(10);
        nums.add(20);
        nums.add(30);
        System.out.println(nums);            // [10, 20, 30]

        // Add at index
        nums.add(1, 15);
        System.out.println(nums);               // [10, 15, 20, 30]

        // Get
        System.out.println(nums.get(2));         // 20

        // Set
        nums.set(2, 25);
        System.out.println(nums);                // [10, 15, 25, 30]

        // Remove
        nums.remove(1);
        System.out.println(nums);               // [10, 25, 30]

        // Contains
        System.out.println(nums.contains(25));           // true

        // Size
        System.out.println(nums.size());            // 3
    }
}