package ArrayListAdder;

import java.util.List;

public class InserterThread2 extends Thread {
    private final List<Integer> list;

    public InserterThread2(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 1000; i < 2000; i++) {
            list.add(i);
        }
        System.out.println(getName() + " finished adding 1000 elements.");
    }
}