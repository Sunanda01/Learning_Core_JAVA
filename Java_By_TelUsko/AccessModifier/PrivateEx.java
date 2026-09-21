package Java_By_TelUsko.AccessModifier;

class A {
    private int data = 40;
    private void msg() {
        System.out.println("Hello Java");
    }
    public void display() {
        System.out.println("Data: " + data);
        msg();
    }
}

class B extends A {
    void access() {
        // System.out.println(data); // Compile Time Error
        // msg(); // Compile Time Error
    }
}

public class PrivateEx {
    public static void main(String args[]) {
        A obj = new A();
        // System.out.println(obj.data); // Compile Time Error
        // obj.msg(); // Compile Time Error
        obj.display();
    }
}
