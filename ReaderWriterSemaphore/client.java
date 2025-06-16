package ReaderWriterSemaphore;
import java.util.*;
import java.util.concurrent.*;

public class client {
    public static void main(String[] args) {
        Semaphore mutex = new Semaphore(1); // for readCount
        Semaphore wrt = new Semaphore(1);   // for writers
        Counter counter = new Counter();

        // Start Readers
        for (int i = 1; i <= 5; i++) {
            new Thread(new Reader(i, mutex, wrt, counter)).start();

        }

        // Start Writers
        for (int i = 1; i <= 3; i++) {
            new Thread(new Writer(i, wrt,counter)).start();

        }
    }
}
