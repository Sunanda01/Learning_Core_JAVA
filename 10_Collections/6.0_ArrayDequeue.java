import java.util.*;

public class 6.0_ArrayDequeue {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();

        // Add at rear
        dq.addLast(20);
        dq.addLast(30);

        // Add at front
        dq.addFirst(10);
        System.out.println(dq);     // [10, 20, 30]

        // View front
        System.out.println(dq.peekFirst());     // 10

        // View rear
        System.out.println(dq.peekLast());     // 30

        // Remove from front
        System.out.println(dq.removeFirst());     // 10

        // Remove from rear
        System.out.println(dq.removeLast());      // 30

        System.out.println(dq);                  // [20]
    }
} {
    
}
