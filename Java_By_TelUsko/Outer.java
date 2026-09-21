package Java_By_TelUsko;
class Outer {
    int x = 10;
    static int y = 20;
    class Inner {
        static void display() {
            System.out.println("Y = " + y);
            System.out.println("Hello from Static Inner class");
        }

        void display1() {
            System.out.println("X = " + x);
            System.out.println("Hello from Non-Static Inner class");
        }
    }

    public static void main(String[] args) {

        // Calling Static method
        Outer.Inner innerObj = new Outer().new Inner();
        innerObj.display();

        // Static method can be called without creating an instance of Inner class
        Outer.Inner.display(); 

        // Non-static Inner class requires an instance of Outer class to be created first
        Outer obj = new Outer();
        Outer.Inner innerObj1 = obj.new Inner();
        innerObj1.display1();
    }
}