package OOPS;
class A{
    public void show1(){
        System.out.println("In Class A");
    }
}
class B extends A{
    public void show2(){
        System.out.println("In Class B");
    }
}
public class ObjectTypeCasting {
    public static void main(String[] args) {
        //Upcasting
        A a=new B();
        a.show1();              //In Class A

        //Downcasting
        B b=(B) a;
        b.show2();              //In Class B
    }
}
