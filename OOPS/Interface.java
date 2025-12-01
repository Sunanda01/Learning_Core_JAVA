package OOPS;
interface InnerInterface {
    int age=24;
    void show();   
}
class A implements InnerInterface{
    public void show(){
        System.out.println("Show in A");
    }
}
public class Interface {
    public static void main(String[] args) {
        A a=new A();
        a.show();
        // A.age=25;                //CTE => cannot assign a value to static final variable age
        System.out.println(A.age);;
    }
}
