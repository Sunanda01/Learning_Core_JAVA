// final class Parent                         // CTE => cannot inherit from final Parent
class Parent
{
    final String name="Ajay Kumar";
    // public final void display()            // CTE => overridden method is final
    // {
    //     System.out.println("In Parent Class");
    // }
}

class Child extends Parent
{
    public void display()        
    {
        System.out.println("In Child Class");
    }
}

public class Final_Example{
    public static void main(String[] args)
    {
        Parent p=new Parent();
        // p.display();
        System.out.println(p.name);
        // p.name="Ashok Kumar";            //CTE => cannot assign a value to final variable name
        Child c=new Child();
        c.display();
    }
}

/*
    - Final variable cannot be re-initialized
    - Final Method cannot be overriden
    - Final Class cannot be inherited
 */