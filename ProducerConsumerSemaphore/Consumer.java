package ProducerConsumerSemaphore;

import java.util.*;
import java.util.concurrent.*;

public class Consumer implements Runnable{
    private Queue<Object>store;
    private int maxSize;
    private String name;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    public Consumer(Queue<Object>store,int maxSize, String name,Semaphore producerSemaphore,Semaphore consumerSemaphore){
        this.store=store;
        this.maxSize=maxSize;
        this.name=name;
        this.producerSemaphore=producerSemaphore;
        this.consumerSemaphore=consumerSemaphore;
    }

    public void run(){
        while(true){
            try{
                consumerSemaphore.acquire(); //if(c>0) c--
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            if (store.size() > 0) {  //if( c>0 then no need to check here)
                System.out.println(this.name + " is consuming an item, Size = " + store.size());
                store.remove(); 
            }
            producerSemaphore.release(); //p++
        }
    }

}
