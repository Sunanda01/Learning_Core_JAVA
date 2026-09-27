package Java_By_TelUsko;

// class Student {
    // private static int id;
    // private static String name;

    // Student(int id, String name) {
    //     this.id = id;
    //     this.name = name;
    // }

    // public int getId() {
    //     return id;
    // }

    // public String getName() {
    //     return name;
    // }
    record Student(int id, String name) {
    //     public Student(int id, String name)
    //     {
    //         this.id = id;
    //         this.name = name;
    //     }
    // }
            // Compact constructor
            public Student{
                if(id==0)
                    throw new IllegalArgumentException("ID cannot be zero");
            }
        }


// }
public class RecordDemo {
    public static void main(String[] args) {

        Student s = new Student(101, "Rahul");

        System.out.println(s.id());
        System.out.println(s.name());
    }
}