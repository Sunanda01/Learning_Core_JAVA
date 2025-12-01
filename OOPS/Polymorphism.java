package OOPS;
class Parent{
    public void walk()
    {
        System.out.println("Parent walk");
    }
}

class Child1 extends Parent{
    public void walk()
    {
        System.out.println("Child1 walk");
    }
}

class Child2 extends Parent{
    public void walk()
    {
        System.out.println("Child2 walk");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Parent parent1=new Parent();
        parent1.walk();                             //Parent Walk

        parent1=new Child1();
        parent1.walk();                             //Child1 walk

        parent1=new Child2();
        parent1.walk();                             //Child2 walk
    }
}

/*
    here parent1.walk() is behaving in different forms
    So this is Polymorphism. The process is dynamic method dispatch.
    Done at runtime
*/