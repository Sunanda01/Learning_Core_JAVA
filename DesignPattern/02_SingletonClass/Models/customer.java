package JavaConceptExample.DesignPattern.SingletonClass.Models;

import JavaConceptExample.DesignPattern.SingletonClass.utils.menu;

public class customer {
    private int id;
    private String name;
    public customer(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "customer [id=" + id + ", name=" + name + "]";
    }    
    public menu viewMenu(){
        return menu.getMenu();
    }
}
