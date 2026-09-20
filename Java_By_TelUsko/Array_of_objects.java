class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Array_of_objects {
    public static void main(String[] args) {

        Student[] students = new Student[3];

        students[0] = new Student("Rahul", 22);
        students[1] = new Student("Priya", 23);
        students[2] = new Student("Amit", 21);

        for (int i = 0; i < students.length; i++) {
            System.out.println(
                students[i].name + " " + students[i].age
            );
        }
    }
}