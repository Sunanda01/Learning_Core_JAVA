interface I1{
    void m1();
}
interface I2 extends I1{
    void m2();
}
interface I3 extends I1{
    int m2();
}
interface I4 extends I3,I2{}

class I5 implements I4{
    public void m1(){
        System.out.println("in m1()");
    }
    public void m2(){                           
        System.out.println("in m2()");
    }
}

public class InterfaceOverriding {
    public static void main(String[] args) {
        I5 i6=new I5();
        i6.m1();
        i6.m2();               //CTE => return type void is not compatible with int
    }
}
