import java.sql.SQLException;

class Parent
{
    public void display() throws Exception
    {
        System.out.println("In Parent Class");
    }
}

class Child extends Parent
{
    // void display()                  //CTE => attempting to assign weaker access privileges; was public
    // public void display() throws Exception      //CTE => overridden method does not throw Exception
    public void display() throws SQLException
    {
        System.out.println("In Child Class");
    }
}

public class Method_Overriding {
    public static void main(String[] args)
    {
        Parent p=new Parent();
        p.display();
        Child c=new Child();
        c.display();
    }
}

/*
 Rules of Method Overriding
    - Access Specifier => Widening
      public>>protected>>default>>private
    
    - Exception => Narrowing
      SuperClass should throw Exception
      SubClass should throw specific Exception. Ex= SQLException
        as SQLException is subclass of Exception

 */