package ProducerConsumerSemaphore;

import java.util.*;
import java.util.concurrent.*;

public class Producer implements Runnable{
    private Queue<Object>store;
    private int maxSize;
    private String name;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    public Producer(Queue<Object>store,int maxSize, String name,Semaphore producerSemaphore,Semaphore consumerSemaphore){
        this.store=store;
        this.maxSize=maxSize;
        this.name=name;
        this.producerSemaphore=producerSemaphore;
        this.consumerSemaphore=consumerSemaphore;
    }
    public void run(){
        while(true){
            try{
                producerSemaphore.acquire(); 
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            if (store.size() < maxSize) {   //if(p>0 then no need to check here)
                System.out.println(this.name + " is producing an item, Size = " + store.size());
                store.add(new Object());
            }  
            consumerSemaphore.release(); 
        }
    }
}
