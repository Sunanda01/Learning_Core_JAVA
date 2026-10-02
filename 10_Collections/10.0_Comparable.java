import java.util.*;

class Student implements Comparable<Student> {

    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student s) {
        return this.marks - s.marks;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + marks;
    }
}

public class 10.0_Comparable {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student(101, "Rahul", 85));
        students.add(new Student(102, "Amit", 92));
        students.add(new Student(103, "Priya", 78));

        Collections.sort(students);

        System.out.println(students);
    }
}