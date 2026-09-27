public class Array {
    public static void main(String[] args) {
        int[][] arr = new int[3][];
        arr[0] = new int[3]; // First row with 3 columns
        arr[1] = new int[4]; // Second row with 4 columns
        arr[2] = new int[2]; // Third row with 2 columns

        // Initialize the jagged array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int)(Math.random() * 10); // Assign random values
            }
        }

        // Print the jagged array using enhanced for loop
        for(int n[]: arr) {
            for(int m: n) {
                System.out.print(m + " ");
            }
            System.out.println();
        }
    }    
}
