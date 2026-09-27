class Student{
    public Student(){
       System.out.println("Default constructor called");
    }

    public Student(String name){
        System.out.println("Parameterized constructor called with name: " + name);
    }

}

public class ConstructorDemo {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Bob");
    }
}