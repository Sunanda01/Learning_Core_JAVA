import java.util.*;

public class 6.2_ArrayDequeue_queue {
    public static void main(String[] args) {
            Deque<Integer> queue = new ArrayDeque<>();

            queue.offerLast(10);
            queue.offerLast(20);
            queue.offerLast(30);

            System.out.println(queue.pollFirst());          // 10
            System.out.println(queue.pollFirst());          // 20
            System.out.println(queue);                      // [30]
        }
}