package Java_By_TelUsko;
import java.io.IOException;
import java.util.*;

public class ExceptionDemo {
    static void readFile() throws IOException {
        throw new IOException("File could not be read");
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try {
            readFile();
            System.out.println("Enter first number => ");
            int a=sc.nextInt();
            System.out.println("Enter second number => ");
            int b=sc.nextInt();
            int div= a/b;
            System.out.println("Result => "+div);
        }
        catch (ArithmeticException e) {
            System.out.println("Arithmetic error");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index error");
        }
        catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Some other exception");
        }
        System.out.println("Program continues...");
    }
}
