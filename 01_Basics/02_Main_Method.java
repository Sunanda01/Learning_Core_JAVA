public class MainMethod2 {
    public static void main(String[] args) {
        System.out.println(args.length);        //0
        System.out.println(args[0]);            //CTE => java.lang.ArrayIndexOutOfBoundsException
        System.out.println(args[0]+args[1]);    //String Concatenation
        System.out.println(
            Integer.parseInt(args[0])
            +Integer.parseInt(args[1])
        );    //Addition
    }
}
