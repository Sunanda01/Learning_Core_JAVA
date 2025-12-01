package Threads;
class Hi extends Thread {
    public void run(){
        for(int i=1;i<100;i++)
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
class Hello extends Thread{
    public void run(){
        for(int i=1;i<100;i++)
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
public class ThreadExample1 {
    public static void main(String[] args) {
        Hi hi=new Hi();
        Hello hello=new Hello();
        System.out.println("Hi Priority => "+hi.getPriority()+"\nHello Priority => "+hello.getPriority());
        hi.start();
        hello.start();
    }
}