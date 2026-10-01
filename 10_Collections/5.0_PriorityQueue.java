import java.util.*;

public class 5.0_PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(30);
        pq.offer(10);
        pq.offer(20);
        pq.offer(5);
        System.out.println(pq);                  // Internal order is NOT guaranteed to be sorted
        System.out.println(pq.peek());          // 5
        System.out.println(pq.poll());          // 5
    }
}