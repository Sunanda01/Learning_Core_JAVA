package Java_By_TelUsko.AccessModifier.ProtectedDemo.ProtectedTest;
import Java_By_TelUsko.AccessModifier.ProtectedDemo.ProtectedEx.A;
public class D {
    public static void main(String[] args) {

        A obj = new A();
        System.out.println("In Class D \n" );
        // System.out.println(obj.data);  // CTE
        // obj.msg();                     // CTE
    }
}
