package JavaConceptExample.DesignPattern.BuilderClass;

public class Student {
    private int regno;
    private String name;
    Student(int regno, String name) {
        this.regno = regno;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Student [regno=" + regno + ", name=" + name + "]";
    }   
    
}
