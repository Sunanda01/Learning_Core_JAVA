package OOPS;
abstract class Vechile{
    public abstract void drive();                   //abstract method
}
public class AbstractExample2 {
    public static void main(String[] args) {         //Anonymous Inner Class
        Vechile v = new Vechile() {
            public void drive(){
                System.out.println("Vechile Drive");
            }
        };
        v.drive();
    }
}
