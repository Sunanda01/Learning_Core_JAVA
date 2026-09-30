import java.util.*;

public class 4.1_LikedList_Using_Queue {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        // 1. Add elements
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        System.out.println(queue);
        // [10, 20, 30]

        // 2. Peek → see front element
        System.out.println(queue.peek());   // 10

        // 3. Poll → remove front element
        System.out.println(queue.poll());   // 10

        System.out.println(queue);         // [20, 30]

        // 4. Add another element
        queue.offer(40);

        System.out.println(queue);        // [20, 30, 40]

        // 5. Check size
        System.out.println(queue.size());    // 3

        // 6. Check empty
        System.out.println(queue.isEmpty());    // false
        queue.clear();
        System.out.println(queue.size());

        // System.out.println(queue.remove());    //NoSuchElementException
        // queue.element();       //NoSuchElementException
    }
}