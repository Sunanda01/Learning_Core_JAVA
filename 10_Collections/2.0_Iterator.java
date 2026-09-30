import java.util.*;

public class 2.0_Iterator {
    public static void main(String[] args) {
        ArrayList<Integer> nums =
                new ArrayList<>(Arrays.asList(10, 20, 30, 40));
        Iterator<Integer> it = nums.iterator();
        while (it.hasNext()) {
            int n = it.next();
            if (n == 20) {
                it.remove();
            }
        }
        System.out.println(nums);
    }
}