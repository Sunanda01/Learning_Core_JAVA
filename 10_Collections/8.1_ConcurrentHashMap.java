import java.util.concurrent.ConcurrentHashMap;

public class 8.1_ConcurrentHashMap {
    public static void main(String[] args) {

        ConcurrentHashMap<Integer, String> map =
                new ConcurrentHashMap<>();

        // Add
        map.put(101, "Rahul");
        map.put(102, "Amit");
        map.put(103, "Priya");

        System.out.println(map);

        // Get
        System.out.println(map.get(101));            // Rahul

        // Update
        map.put(101, "Rohan");

        // Check
        System.out.println(map.containsKey(102));       // true

        // Remove
        map.remove(103);
        System.out.println(map);

        // Size
        System.out.println(map.size());
    }
}