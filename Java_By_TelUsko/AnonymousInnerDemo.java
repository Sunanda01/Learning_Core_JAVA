package Java_By_TelUsko;
abstract class Animal {
    abstract void sound();
}

public class AnonymousInnerDemo {

    public static void main(String[] args) {

        Animal dog = new Animal() {
            @Override
            public void sound() {
                System.out.println("Dog barks");
            }
        };
        dog.sound();
    }
}

