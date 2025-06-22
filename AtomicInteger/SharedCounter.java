package AtomicInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class SharedCounter {
    // private volatile int counter=0;
    private AtomicInteger counter=new AtomicInteger(0);

    public void increment(){
        counter.incrementAndGet();
        // counter++;
    }

    public int getCounter(){
        return counter.get();
        // return counter;
    }
}
