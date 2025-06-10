package ProducerConsumer;

import java.util.*;

public class Consumer implements Runnable{
    private Queue<Object> store;
    private int maxSize;
    private String name;

    public Consumer(Queue<Object> store, int maxSize, String name) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
                synchronized(Queue.class){
                    if (store.size() > 0) { 
                        System.out.println(this.name + " is consuming an item, Size = " + store.size());
                        store.remove(); 
                }
                }
        }
    }
}
