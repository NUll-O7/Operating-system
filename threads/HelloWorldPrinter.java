package threads;

public class HelloWorldPrinter implements Runnable{
    public static void doSomething(){
        System.out.println("Done with it " +" Thread : "+Thread.currentThread().getName());
    }
    public void run(){
        System.out.println("hello world"+  " Thread "+Thread.currentThread().getName());
        doSomething();
    }
}