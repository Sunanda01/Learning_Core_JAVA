package Java_By_TelUsko.AccessModifier.ProtectedDemo.ProtectedTest;
import Java_By_TelUsko.AccessModifier.ProtectedDemo.ProtectedEx.A;

public class C extends A {
    void access() {
        System.out.println("In Child Class C \n" + data); 
        msg(); 
    }   
    public static void main(String args[]) {   
        C obj2 = new C();
        obj2.access();
    }
}
