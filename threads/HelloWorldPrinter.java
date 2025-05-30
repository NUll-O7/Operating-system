package threads;

public class HelloWorldPrinter implements Runnable{
    void dosomething(){
        System.out.println("heeloo for thread " +" Thread  : " + Thread.currentThread().getName()) ;
    }
    
    public void run(){
        System.out.println("hello world"+  " Thread :"+Thread.currentThread().getName());
        dosomething();
    }

    /*
     * A[]=[1,2,3,4]
     * Create a thread that will take one elementf from this array , 
     * calculate factorial and then store it inside ans array
     */
}