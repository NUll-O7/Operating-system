package AdderSubtractorMutex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class client {
    public static void main(String[]args) throws InterruptedException {
        Count count=new Count(0);
        Lock lock = new ReentrantLock();

        Adder ad=new Adder(count,lock);
        Subtractor sub=new Subtractor(count,lock);

        Thread t1=new Thread(ad);
        Thread t2=new Thread(sub);

        t1.start();
        t2.start();

        t1.join(); // main thread will stop execution and waits for t1 to finish
        t2.join(); //main thread will stop until t2 is done

        System.out.println(count.value);
    }

}
