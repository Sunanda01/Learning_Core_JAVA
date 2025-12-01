abstract class Calc{
    static String calName="XYZ";
    int sum,diff,prod;
    public abstract void add(int x,int y);
    public abstract void diff(int x,int y);
    public abstract void mul(int x,int y);
}
abstract class Calc1 extends Calc{
    public void add(int x,int y){
        sum= x+y;
        System.out.println(sum);
    }
    public abstract void diff(int x,int y);
}
class Calc2 extends Calc1{
    public void diff(int x,int y){
        diff= x-y;
        System.out.println(diff);
    }
    // public void mul(int x,int y){}      //Cheating Compiler
    public void mul(int x,int y){
        prod=x*y;
        System.out.println(prod);
    }
}
public class AbstractEx {
    public static void main(String[] args) {
        System.out.println(Calc.calName);
        //Method 1: Inner Class
        Calc c1=new Calc(){
            public void add(int x,int y){
                System.out.println(x+y);
            }
            public void diff(int x,int y){
                System.out.println(x-y);
            }
            public void mul(int x,int y){
                System.out.println(x*y);
            }
        };
        c1.add(10,20);
        c1.diff(30,20);
        c1.mul(450,320);

        // Method 2: Creating Objects of Child Class
        // Calc c2=new Calc1();    //CTE
        Calc c3=new Calc2();
        c3.add(100,200);
        c3.diff(100,200);
        c3.mul(100,200);
    }
}
