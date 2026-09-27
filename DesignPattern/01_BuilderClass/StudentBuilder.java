package JavaConceptExample.DesignPattern.BuilderClass;
public class StudentBuilder{
    private int regno;
    private String name;
    public StudentBuilder setRegno(int regno) {
        this.regno = regno;
        return this;
    }
    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    } 
    public Student build(){
        return new Student(regno,name);
    }
    
}