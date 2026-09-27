package OOPS;
class A{
    public A(){
        System.out.println("In A constructor");
    }  
    public A(int a){
        System.out.println("In A constructor int");
    }        
}
class B extends A{
    public B(){
        super();
        System.out.println("In B constructor");
    }      
    public B(int a){
        this();
        System.out.println("In B constructor int");
    }     
}
public class SuperExample {
    public static void main(String[] args) {
        B b=new B(5);
    }
}

/*
Output
    In A constructor
    In B constructor
    In B constructor int

Creating the object with args calls parameterized constructor
then the parameterized constructor calls the object using this
which again calls constructor of A => super refers to parent calss
*/