package JavaConceptExample.DesignPattern.SingletonClass.utils;
import java.util.ArrayList;
import java.util.Arrays;

import JavaConceptExample.DesignPattern.SingletonClass.Models.item;
public class menu {
    private ArrayList<item> listOfItems=new ArrayList<item>(
        Arrays.asList(
            new item("Dosa",30),
            new item("idli",70)
        )
    );

    private static menu m=null;
    private menu(){}
    public static menu getMenu(){
        if(m==null)
            m = new menu();
        return m;
    }
    @Override
    public String toString() {
        return "menu [listOfItems=" + listOfItems + "]";
    } 
}
