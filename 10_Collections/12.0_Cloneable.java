class Student implements Cloneable {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}

public class 12.0_Cloneable {
    public static void main(String[] args) throws CloneNotSupportedException {

        Student s1 = new Student(101, "Rahul");
        Student s2 = s1.clone();

        System.out.println(s2.id);
        System.out.println(s2.name);

        System.out.println(s1 == s2);                    // false
    }
}