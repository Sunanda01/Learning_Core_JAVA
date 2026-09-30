import java.util.*;

public class 4.0_LikedList_Using_List {
    public static void main(String[] args) {
        List<Integer> nums = new LinkedList<>();
        // 1. Add
        nums.add(10);
        nums.add(20);
        nums.add(30);

        System.out.println(nums);  // [10, 20, 30]

        // 2. Add at index
        nums.add(1, 15);
        System.out.println(nums);  // [10, 15, 20, 30]

        // 3. Get
        System.out.println(nums.get(2));  // 20

        // 4. Set / Replace
        nums.set(2, 25);
        System.out.println(nums);    // [10, 15, 25, 30]

        // 5. Remove by index
        nums.remove(1);
        System.out.println(nums);    // [10, 25, 30]

        // 6. Remove by value
        nums.remove(Integer.valueOf(25));
        System.out.println(nums);    // [10, 30]

        // 7. Contains
        System.out.println(nums.contains(30));   // true

        // 8. Size
        System.out.println(nums.size());   // 2

        // 9. Clear
        nums.clear();   
        System.out.println(nums);    // []
    }
}