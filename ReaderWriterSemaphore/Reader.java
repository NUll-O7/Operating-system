package ReaderWriterSemaphore;

import java.util.concurrent.Semaphore;

public class Reader implements Runnable {
    private final int id;
    private final Semaphore mutex;
    private final Semaphore wrt;
    private final Counter counter;

    public Reader(int id, Semaphore mutex, Semaphore wrt, Counter counter) {
        this.id = id;
        this.mutex = mutex;
        this.wrt = wrt;
        this.counter = counter;
    }

    public void run() {
        try {
            // Entry section
            mutex.acquire();  
            counter.increment();
            if (counter.get() == 1)
                wrt.acquire(); // First reader blocks writers
            mutex.release();

            // Critical Section
            System.out.println("Reader " + id + " is reading..."); //r1,r2
            Thread.sleep(1000);

            // Exit section
            mutex.acquire(); 
            counter.decrement();
            if (counter.get() == 0)
                wrt.release(); // Last reader releases writer
            mutex.release();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
