package JavaConceptExample.DesignPattern.SingletonClass.Models;
public class item {
    String item_name;
    int item_price;
    public item(String item_name, int item_price) {
        this.item_name = item_name;
        this.item_price = item_price;
    }
    @Override
    public String toString() {
        return "item [item_name=" + item_name + ", item_price=" + item_price + "]";
    }  
}
