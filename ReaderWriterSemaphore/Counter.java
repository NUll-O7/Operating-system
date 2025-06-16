package ReaderWriterSemaphore;

public class Counter {
    private int count = 0;

    public  void increment() {
        count++;
    }

    public  void decrement() {
        count--;
    }

    public  int get() {
        return count;
    }

    public void write(int value) {
        count = value;
    }
}
