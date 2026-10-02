import java.util.*;

class Student {

    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + marks;
    }
}

public class 10.1_Comparator {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student(101, "Rahul", 85));
        students.add(new Student(102, "Amit", 92));
        students.add(new Student(103, "Priya", 78));

        // Sort by marks
        students.sort(
            Comparator.comparingInt(s -> s.marks)
        );

        System.out.println(students);

        // Sort by name
        students.sort(
            Comparator.comparing(s -> s.name)
        );

        System.out.println(students);
    }
}