package JavaConceptExample.DesignPattern.SingletonClass;

import JavaConceptExample.DesignPattern.SingletonClass.Models.customer;
import JavaConceptExample.DesignPattern.SingletonClass.utils.menu;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("South Indian Taste");
        customer c1=new customer(1,"Sunanda");
        menu m1=c1.viewMenu();
        System.out.println(m1);

        customer c2=new customer(2,"Shubho");
        menu m2=c2.viewMenu();
        System.out.println(m2);
    }
}
