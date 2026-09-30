public class 1.0_ArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        // 1. Add
        nums.add(10);
        nums.add(20);
        nums.add(30);

        System.out.println(nums);                    // [10, 20, 30]

        // 2. Add at specific index
        nums.add(1, 15);                            
        System.out.println(nums);                   // [10, 15, 20, 30]

        // 3. Get
        System.out.println(nums.get(2));            // 20


        // 4. Set / Replace
        nums.set(2, 25);
        System.out.println(nums);                   // [10, 15, 25, 30]

        // 5. Contains
        System.out.println(nums.contains(25));      // true

        // 6. Size
        System.out.println(nums.size());            // 4

        // 7. Remove using index
        nums.remove(1);
        System.out.println(nums);                   // [10, 25, 30]

        // 8. Remove using object
        nums.remove(Integer.valueOf(25));
        System.out.println(nums);                   // [10, 30]

        // 9. Check empty
        System.out.println(nums.isEmpty());         // false

        // 10. Clear                            
        nums.clear();                               
        System.out.println(nums);                   // []
    }
}