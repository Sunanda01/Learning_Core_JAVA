interface Consumer{
    void accept(int x);
}
interface Function{
    String apply(int x);
}
interface Predicate{
    boolean test(int x);
}

public class FunctionInterfaceExample { 
    public static void main(String[] args) 
    { 
        int i; 
        int arr[]= {10,20,30,40,50}; 
        Consumer con=(x)->System.out.print(x+" "); 
        for(i=0;i<arr.length;i++) 
            con.accept(arr[i]); 
        System.out.println(); 
        
        Predicate pred=(x)->x>=30; 
        for(i=0;i<arr.length;i++) 
            System.out.print(pred.test(arr[i])+"\t"); 
        System.out.println(); 
        
        Function fn=(x)-> 
        {
            if(x<30) return "Less than 30"; 
            else if(x==30) return "Equal to 30"; 
            return "More than 30"; 
        }; 
        for(i=0;i<arr.length;i++) 
            System.out.print(fn.apply(arr[i])+"\t"); 
        } 
}
/*
    Consumer    =>   Accept
    Predicate   =>   Test
    Functional  =>   Apply
    Supplier    =>   Get
 */
