import java.util.Scanner;
class College{
    public final static String cName="DSCASC";
}
class HOD extends College{
    private int hodId;
    private String name;
    private HOD(int hodId,String name){
        this.hodId=hodId;
        this.name=name;
    }
    public String toString(){
        return hodId+" : "+name;
    }
    public static HOD getHod(int hodId, String name) {
        if(hodId<20) return new HOD(hodId, name);
        else return null;        
    }
}

class Student extends College{
    private int stuId;
    private String name;
    private Student(int stuId,String name){
        this.stuId=stuId;
        this.name=name;
    }
    public String toString(){
        return stuId+" : "+name;
    }
    public static Student getStudent(int stuId,String name){
        if(stuId<100)   return new Student(stuId, name);
        else return null;
    }
}

public class FactoryBuilderPattern2 {
    private static String dropDown=null;
    private static int idval=0;
    private static String nameVal=null;

    private static College getAccess(String dropDown, int idval,String nameVal){
        if(dropDown.equals("HOD")){
            return HOD.getHod(idval,nameVal);
        }
        else if(dropDown.equals("Student")){
            return Student.getStudent(idval,nameVal);
        }
        else{
            return null;
        }
    }
    public static void main(String[] args) {
        System.out.println(College.cName);
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter from Dropdown [ HOD, Student]");
        dropDown=scanner.next();
        System.out.println("Enter id and name => ");
        idval=scanner.nextInt();
        scanner.nextLine();
        nameVal=scanner.next();

        College college=getAccess(dropDown,idval,nameVal);
        if(college==null)  System.out.println("INVALID ID!!!!!!!!!");
        else System.out.println(college);
        scanner.close();
    }
}
