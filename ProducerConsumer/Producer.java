package ProducerConsumer;

import java.util.*;

public class Producer implements Runnable{

    private Queue<Object> store;
    private int maxSize;
    private String name;

    public Producer(Queue<Object> store, int maxSize, String name) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
    }


    @Override
    public void run() {
        while (true) {   
            synchronized(Queue.class){
                if (store.size() < maxSize) { //p1, p2,p3,p4 storesize=5
                    System.out.println(this.name + " is producing an item, Size = " + store.size());
                    store.add(new Object());
                }  

            }
        }
    }
}