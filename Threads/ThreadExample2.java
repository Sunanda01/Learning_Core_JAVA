package Threads;
class Hi implements Runnable {
    public void run(){
        for(int i=1;i<5;i++)
        {
            System.out.println("Hi");
            try
            {
                Thread.sleep(5000);
            }
            catch(InterruptedException e)
            {
                System.out.println("Thread Interrupted\n"+e);
            }
        }
    }
}
class Hello implements Runnable{
    public void run(){
        for(int i=1;i<5;i++)
        {
            System.out.println("Hello");
            try{
                Thread.sleep(5000);
            }
            catch(InterruptedException e){
                System.out.println("Thread Interrupted\n"+e);
            }
        }
    }
}
public class ThreadExample2 {
    public static void main(String[] args) {
        Hi hi=new Hi();
        Hello hello=new Hello();
        Thread t1=new Thread(hi);
        Thread t2=new Thread(hello);
        t1.start();
        t2.start();
    }
}   

// using lamba expression
// Runnable obj=()->{
//     for(int i=1;i<5;i++)
//         {
//             System.out.println("Hello");
//             try{
//                 Thread.sleep(5000);
//             }
//             catch(InterruptedException e){
//                 System.out.println("Thread Interrupted\n"+e);
//             }
//         }
// };