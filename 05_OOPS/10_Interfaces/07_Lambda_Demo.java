package OOPS;
@FunctionalInterface
interface A {
    // void show();
    // void show(int i);
    int add(int a,int b);
}
public class LambaExampl1 {
    public static void main(String[] args) {
        // A a = ()->System.out.println("Show()");
        // A a = (i)->System.out.println("show() "+ i);
        A a=(i,j) -> i+j;
        int res=a.add(10,20);
        System.out.println(res);
    }
}
