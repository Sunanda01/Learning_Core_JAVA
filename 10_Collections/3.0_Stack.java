import java.util.Stack;

public class 3.0_Stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // 1. push() → add element
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack);               // [10, 20, 30]

        // 2. peek() → see top element
        System.out.println(stack.peek());        // 30
        System.out.println(stack);
        
        // 3. pop() → remove top element
        System.out.println(stack.pop());         // 30
        System.out.println(stack);               // [10, 20]

        // 4. empty()
        System.out.println(stack.empty());       // false

        // 5. search()
        System.out.println(stack.search(10));    // 2
    }
}