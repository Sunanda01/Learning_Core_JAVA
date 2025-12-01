package OOPS;
enum laptop{
    HP(5000),Dell(2000),Acer(2500),Asus();
    private int price;
    laptop(){
        price=3000;
    }
    laptop(int price){
        this.price=price;
    }
    public int getPrice(){
        return price;
    }
}
public class EnumExample2 {
    public static void main(String[] args) {
        for(laptop l:laptop.values()){
            System.out.println(l+" : "+l.getPrice());
        }
    }
}
