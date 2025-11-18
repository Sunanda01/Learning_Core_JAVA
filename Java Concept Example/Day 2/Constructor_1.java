class Student
{
    static String cName="DSCASC";
    //Non Static Member
    int regNo;
    String name;
    long mob;
    String email;

    //Constructor Overloading
    Student(int regNo, String name)
    {
        this.regNo=regNo;
        this.name=name;
        System.out.println("Return ( regNo,name )");
    }
    Student(int regNo, String name, long mob)
    {
        this(regNo,name);
        this.mob=mob;
        System.out.println("Return ( regNo, name, mob )");
    }
    Student(int regNo, String name, long mob, String email)
    {
        this(regNo,name,mob);
        this.email=email;
        System.out.println("Return ( regNo, name, mob, email )");
    }
}
public class Constructor_1 
{
    public static void main(String[] args)
    {
        Student s1=new Student(101, "Sunanda");
        Student s2=new Student(102, "Shubho", 9878986543L);
        Student s3=new Student(101, "Priyanka", 9890987654L, "p@gmail.com");
    }
}
