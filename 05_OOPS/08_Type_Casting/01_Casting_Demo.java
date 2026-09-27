package Java_By_TelUsko;
class Animal {
    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

public class CastingDemo {
    public static void main(String[] args) {
        // ---------------- UPCASTING ----------------
        Animal animal = new Dog();   // Upcasting
        animal.eat();         
        // animal.bark();      //  Cannot access Dog-specific method


        // ---------------- DOWNCASTING ----------------
        Animal a = new Dog();
        Dog d = (Dog) a;       // Downcasting
        d.eat();               // inherited method
        d.bark();              // Dog-specific method
    }
}

