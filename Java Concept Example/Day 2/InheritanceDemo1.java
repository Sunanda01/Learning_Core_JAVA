class HOD
{
    private final void hod_pwd()
    {
        System.out.println("HOD Password");
    }
    public void tt()
    {
        System.out.println("HOD TimeTable");
    }
}

class Lecturer extends HOD
{
    public void lec_pwd()
    {
        // hod_pwd();               //CTE => hod_pwd() has private access in HOD
        System.out.println("Lecturer Password");
    }
    public void tt()
    {
        System.out.println("Lecturer TimeTable");
    }
}

public class InheritanceDemo1 {
    public static void main(String[] args)
    {
        HOD h1=new HOD();  
        // h1.hod_pwd();                       //CTE => hod_pwd() has private access in HOD
        h1.tt();

        Lecturer l1=new Lecturer();
        l1.lec_pwd();
        l1.tt();
        // l1.hod_pwd();                    //Invalid => Avoid this case

        h1=new Lecturer();
        h1.tt();                             //Lecturer's Time Table  => Valid
        // h1.lec_pwd();                    //CTE => error: cannot find symbol  
        //Super Class cannot access the members of sub class

    }
}
