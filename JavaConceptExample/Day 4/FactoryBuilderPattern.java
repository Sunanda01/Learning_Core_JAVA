class Movie{
    String name;
    String language;
    public Movie(String name, String language) {
        this.name = name;
        this.language = language;
    }
    @Override
    public String toString() {
        return "Movie \nName => " + name + "\nLanguage => " + language;
    }
}
class Movie1{
    private final static int amount=99;
    String name="Kantara";
    String language="Kannada";
    private Movie1() {
        System.out.println("Paid!!!!!!! \nPay 99/-");
    }
    public static Movie1 getMovie1(int amountPaid){         //Static Factory Method
        if(amount==amountPaid){
            return new Movie1();
        }
        return null;
    }
    @Override
    public String toString() {
        return "Paid Movies \nName => " + name + "\nLanguage => " + language;
    } 
}
public class FactoryBuilderPattern {
    public static void main(String[] args) {
        Movie movie=new Movie("Om Shanti Om","Hindi");
        System.out.println(movie);
        System.out.println();
        
        // Block the access
        // Movie1 movie1=new Movie1("kantara","Kannada");
        // System.out.println(movie1);

        Movie1 movie1=Movie1.getMovie1(99);
        System.out.println(movie1);        
    }
}
