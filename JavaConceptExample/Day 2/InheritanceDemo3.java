class Parent
{
    private void badHabit()
    {
        System.out.println("Parent's bad habit");
    }
    public final void goodHabit()
    {
        System.out.println("Parent's good habit");
    }
}

class Child extends Parent
{
    private void badHabit()                  //Private methods cannot be overriden
    {
        // super.badHabit();                //Invalid
        System.out.println("Child's bad habit");
    }
    // public void goodHabit()              ////Final methods cannot be overriden
    // {
    //     System.out.println("Child's good habit");
    // }
}

public class InheritanceDemo3 {
    public static void main(String[] args)   
    {
        Parent p=new Parent();
        // p.badHabit();                    //Cannot be accessed
        p.goodHabit();
        Child c=new Child();
        // c.badHabit();
        c.goodHabit();                      //Can be accessed
    }
}

/*
 - Private Methods
        Cannot be inherited
        Can be overriden
        Cannot be accessed

 - Final Methods
        Can be inherited
        Cannot Overriden
        Can be accessed
 */