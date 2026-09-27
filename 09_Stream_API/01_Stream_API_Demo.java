package Java_By_TelUsko;
import java.util.*;
class StreamAPIDemo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 5, 7, 3, 2, 6);

        int result = nums.stream()
                         .filter(n -> n % 2 == 0)
                         .map(n -> n * 2)
                         .reduce(0, (c, e) -> c + e);
        System.out.println(result);
    }
}
