package Java_By_TelUsko;

sealed class Vehicle permits Car, Bike {
    void show() {
        System.out.println("This is a vehicle");
    }
}

final class Car extends Vehicle {
    void drive() {
        System.out.println("Car is driving");
    }
}

non-sealed class Bike extends Vehicle {
    void ride() {
        System.out.println("Bike is riding");
    }
}

// Allowed because Bike is non-sealed
class SportsBike extends Bike {
    void race() {
        System.out.println("SportsBike is racing");
    }
}

public class SealedClassDemo {
    public static void main(String[] args) {

        Vehicle v1 = new Car();
        v1.show();

        Vehicle v2 = new Bike();
        v2.show();

        SportsBike s = new SportsBike();
        s.ride();
        s.race();
    }
}