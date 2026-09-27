import java.util.Objects;

class Student{
    int regNo;
    String name;
    Student(int regNo,String name){
        this.regNo=regNo;
        this.name=name;
    }

    @Override
    public String toString(){
        return name+" : "+regNo;
    }

    @Override
    public boolean equals(Object inObject){
        if(inObject instanceof Student){
            Student s=(Student) inObject;
            return(regNo==s.regNo);
        }
        return false;
    }

    public int hashCode(){
        return Objects.hash(regNo,name);
    }
}
public class ClassObjectEx {
    public static void main(String[] args) {
        Student student=new Student(101,"Sunanda");
        System.out.println(student);
        Student student1=new Student(102,"Sunanda");
        System.out.println(student.equals(student1));
        System.out.println(student.hashCode());
        Student student3=new Student(103,"Su");
        System.out.println(student3 instanceof Student);
    }
    
}
