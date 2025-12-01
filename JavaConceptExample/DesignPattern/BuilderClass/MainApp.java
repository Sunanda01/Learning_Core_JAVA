package JavaConceptExample.DesignPattern.BuilderClass;

public class MainApp {
    public static void main(String[] args) {
        StudentBuilder sb=new StudentBuilder();
        Student s1=sb.setRegno(101).setName("Sunanda").build();
        System.out.println(s1);
        Student s2=sb.setRegno(102).setName("Priyanka").build();
        System.out.println(s2);
    }
}
