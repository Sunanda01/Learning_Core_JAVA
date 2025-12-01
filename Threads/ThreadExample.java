package Threads;
class Counter{
    private int a=10;
    public synchronized int increment(){
        return ++a;
    }
    public synchronized int decrement(){
        return --a;
    }
}
public class ThreadExample{
    public static void main(String[] args) {
        Counter c1=new Counter();
        System.out.println("Main Starts");
        for(int i=1;i<200;i++) 
        {
            Runnable inrObj=()->System.out.println(Thread.currentThread().getName()+" : "+c1.increment());
            Runnable decObj=()->System.out.println(Thread.currentThread().getName()+" : "+c1.decrement());
            Thread t1=new Thread(inrObj);
            Thread t2=new Thread(decObj);
            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();

            } catch (InterruptedException e) {
                System.out.println("INTERRUPTED THREAD");
            }
        }
        System.out.println("Main Ends");
    }
}