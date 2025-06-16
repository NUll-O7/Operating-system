package ReaderWriterSemaphore;

import java.util.*;
import java.util.concurrent.*;

public class Writer implements Runnable {
    private  int id;
    private  Semaphore wrt;
    private final Counter counter;

    public Writer(int id, Semaphore wrt,Counter counter) {
        this.id = id;
        this.wrt = wrt;
        this.counter=counter;
    }

    public void run() {
        try {
            wrt.acquire(); 

            // Critical Section
            int value = (int)(Math.random() * 100);  // generate random value
            System.out.println("Writer " + id + " is writing value: " + value);
            counter.write(value);
            Thread.sleep(1000);

            wrt.release(); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
