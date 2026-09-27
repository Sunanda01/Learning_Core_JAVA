package Java_By_TelUsko;

class AgeException extends Exception {

    AgeException(String message) {
        super(message);
    }
}

public class CustomException {

    static void checkAge(int age) throws AgeException {

        if (age < 18) {
            throw new AgeException("Age must be 18 or above");
        }

        System.out.println("Eligible");
    }

    public static void main(String[] args) {

        try {
            checkAge(15);
        }
        catch (AgeException e) {
            System.out.println(e.getMessage());
        }
    }
}