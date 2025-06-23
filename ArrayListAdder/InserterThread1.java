package ArrayListAdder;

import java.util.List;
import java.util.concurrent.locks.Lock;

public class InserterThread1 extends Thread {
    private final List<Integer> list;
    public Lock lock;

    public InserterThread1(List<Integer> list,Lock l) {
        this.list = list;
        lock=l;
    }

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            lock.lock();
            list.add(i);
            lock.unlock();
        }
        System.out.println(getName() + " finished adding 1000 elements.");
    }
}
