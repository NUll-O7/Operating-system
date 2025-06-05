package AdderSubtractorMutex;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
    public Count count;
    public Lock lock;

    public Adder(Count c,Lock l){
        count=c;
        lock=l;
    }
    public void run(){
        for(int i=0;i<=100000;i++){
            lock.lock();
            count.value+=i;
            lock.unlock();
        }
    }
    
}
