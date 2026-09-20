class Student {

    // 1. Static variable
    static String college = "DSCE";
    String dept = "CSE";

    // 2. Static block
    static {
        System.out.println("Static block executed");
        college = "Dayananda Sagar College";
        // dept = "Computer Science"; // This will cause a compilation error because 'dept' is not static
    }

    // 3. Static method
    static void displayCollege() {
        System.out.println("College: " + college);
        System.out.println("Department: " + new Student().dept); // Accessing non-static variable using an instance of the class
        // System.out.println("Department: " + dept); // This will cause a compilation error because 'dept' is not static
    }
}
public class StaticDemo {
    public static void main(String[] args) {
        System.out.println("Main method executed");
        System.out.println(Student.college); // Accessing static variable using class name
        // Calling static method using class name
        Student.displayCollege();
    }
}
