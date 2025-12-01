interface I1{
    int a=10;
    int calMax(int a,int b);
}

public class InterfaceEx2 {
    public static void main(String[] args) {
        // I1 i=new I1();      //CTE => Cannot instantiate the type I1
        System.out.println(I1.a);
        // method 1 => Inner Class
        // I1 i=new I1(){
        //     public int calMax(int a,int b){
        //         return (a>b?a:b);
        //     }
        // };

        // Method 2 => lambda Expression
        I1 i=(a,b)->a>b?a:b;
        System.out.println("Max Number => "+i.calMax(20,30));
    }  
}