package Java_By_TelUsko;

class VarDemo
{
    // var num = 10; // error - var not allowed as instance variable
    public static void main(String args[])
    {
        int a = 9;
        var b = 8;
        String var = "Navin"; // 'var' can be used as variable name too
        int c;
        // var d;   // cannot use 'var' on variable without initializer
        // var nums[] = new int[10];     // 'var' is not allowed as an element type of an array
        var nums = new int[10];
        Alien obj = new Alien();
    }
}

// Dummy class to make it compile
class Alien
{
}