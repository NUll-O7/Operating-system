package ArrayListAdder;

import java.util.List;

public class InserterThread1 extends Thread {
    private final List<Integer> list;

    public InserterThread1(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        System.out.println(getName() + " finished adding 1000 elements.");
    }
}
