import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {

        Student s = (Student) obj;

        return this.id == s.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}

public class 7.5_HashSet {
    public static void main(String[] args) {

        Set<Student> students = new HashSet<>();

        students.add(new Student(101, "Rahul"));
        students.add(new Student(101, "Rahul"));

        System.out.println(students.size());
    }
}

