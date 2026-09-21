package Java_By_TelUsko.AccessModifier.DefaultDemo;

import Java_By_TelUsko.AccessModifier.DefaultDemo.DefaultEx.A;

public class B {
    public static void main(String[] args) {
        System.out.println("In Class B");
        A obj = new A();
        // System.out.println(obj.data); // CTE
        // obj.msg(); // CTE
    }
}
