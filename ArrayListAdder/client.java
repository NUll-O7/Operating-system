package ArrayListAdder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class client {
    public static void main(String[] args) {
        // List<Integer> sharedList = new CopyOnWriteArrayList<>();
        Lock lock = new ReentrantLock();
        List<Integer> sharedList=new ArrayList<>(); 

        InserterThread1 thread1 = new InserterThread1(sharedList,lock);
        InserterThread2 thread2 = new InserterThread2(sharedList,lock);

        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the size of the ArrayList
        System.out.println("Expected size: 2000");
        System.out.println("Actual size: " + sharedList.size());
    }
}

