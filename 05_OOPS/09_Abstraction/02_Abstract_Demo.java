package OOPS;
abstract class Vechile{
    public abstract void drive();                   //abstract method
    public void playMusic(){                        //concrete method
        System.out.println("Playing Music");
    }
}
class Car extends Vechile{
    public void drive(){
        System.out.println("Car Driving!!!!!");
    }
    public void playMusic(){
        System.out.println("Playing music in car");
    }
}
public class AbstractExample {
    public static void main(String[] args) {
        Car c=new Car();
        c.playMusic();
        c.drive();
    }
}
