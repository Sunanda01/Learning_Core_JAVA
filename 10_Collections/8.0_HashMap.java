import java.util.*;

public class 8.0_HashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();

        // Add
        students.put(101, "Rahul");
        students.put(102, "Amit");
        students.put(103, "Priya");

        System.out.println(students);

        // Get value using key
        System.out.println(students.get(101));                  // Rahul

        // Check key
        System.out.println(students.containsKey(102));          // true

        // Check value
        System.out.println(students.containsValue("Priya"));     // true

        // Replace value
        students.put(101, "Rohan");
        System.out.println(students.get(101));                  // Rohan

        // Remove using key
        students.remove(102);
        System.out.println(students);

        // Size
        System.out.println(students.size());

        // Check empty
        System.out.println(students.isEmpty());

        // Iterating HashMap
        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println(
                entry.getKey() + " => " + entry.getValue()
            );
        }

        System.out.println(students.keySet());                  // all keys
        System.out.println(students.values());                  // all values
        System.out.println(students.entrySet());                // key-value pairs
    }
}