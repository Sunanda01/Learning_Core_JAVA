public class Byte_Ex 
{
    public static void main(String[] args)
    {
        byte b1 = 10;                   //10
        System.out.println(b1);
        byte b2 = (byte) 258;           //2
        System.out.println(b2);
        byte b3 = (byte) 1000;          //-24
        System.out.println(b3);
        byte a=10 , b=20;
        // byte sum=a + b;              //CTE => incompatible types: possible lossy conversion from int to byte
        int sum = a + b;
        System.out.println(sum);        //30
    }
}

/*
 * Byte , Short are directly changed to int => AutoPromotion
 */