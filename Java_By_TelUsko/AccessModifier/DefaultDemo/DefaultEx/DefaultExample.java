package Java_By_TelUsko.AccessModifier.DefaultDemo.DefaultEx;

public class DefaultExample {
    public static void main(String[] args) {
        A obj = new A();
        System.out.println(obj.data +"\nAfter Increment: "+obj.increment());
        obj.msg();
    }
}
