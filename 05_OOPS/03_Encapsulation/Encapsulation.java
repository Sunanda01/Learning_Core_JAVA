package OOPS;
class Student
{
    private int regNo;
    private String name;
    public int getRegNo()
    {
        return regNo;
    }
    public String getName()
    {
        return name;
    }
    public void setRegNo(int regNo)
    {
        this.regNo=regNo;
    }
     public void setName(String name)
    {
        this.name=name;
    }
    @Override 
    public String toString()
    {
        return "Register Number => "+regNo
                +"\nName => "+name;
    }
}
public class Encapsulation{
    public static void main(String[] args) {
        Student student=new Student();
        student.setName("Priyanka");
        student.setRegNo(101);
        System.out.println(student);
    }
}

//Compile => javac OOPS/Encapsulation.java
//Run => java OOPS/Encapsulation