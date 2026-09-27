package OOPS;

@FunctionalInterface
interface A {
    void show();
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        A a = new A() {
            public void show() {
                System.out.println("Show()");
            }
        };
        a.show();
    }
}
