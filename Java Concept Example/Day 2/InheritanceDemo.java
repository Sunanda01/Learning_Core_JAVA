class V1
{
    static String cname="DSCASC";           //Static Member
    //Non Static Member
    int regNo;
    String name;

    V1(int regNo, String name)
    {
        this.regNo=regNo;
        this.name=name;
    }

    public void displayStudentDetails()
    {
        System.out.println("Register Number = "+regNo+"\nName = "+name);
    }
}

class V2 extends V1                                         //Inheritance
{
    long mob;
    String email;
    V2(int regNo, String name, long mob, String email)
    {
        super(regNo,name);                                  //Constructor Chaining
        this.mob=mob;
        this.email=email;
    }

    public void displayStudentDetails()
    {
        System.out.println("Register Number = "+regNo+"\nName = "+name+"\nMobile Number = "+mob+"\nEmail Id = "+email);
    }
}

public class InheritanceDemo 
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to College "+V1.cname.toUpperCase());
        V1 v1=new V1(101,"Priyanka");
        v1.displayStudentDetails();

        //Tight Coupling 
        V2 v2=new V2(102,"Shubhodeep",9908769087L,"s@gmail.com");
        v2.displayStudentDetails();                         //Polymorphism

        //Loose Coupling 
        v1=new V2(103,"Soumya",9875432323L,"soumya@gmail.com");
        v1.displayStudentDetails();
    }
    
}
