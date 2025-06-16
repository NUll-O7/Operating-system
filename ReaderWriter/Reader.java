package ReaderWriter;

public class Reader extends Thread {
    private final int id;
    private final Counter counter;

    public Reader(int id, Counter counter) {
        this.id = id;
        this.counter = counter;
    }

    public void run() {
        Sy.println("Reader " + id + "stem.out is reading value: " + counter.get());
        try {
            Thread.sleep(500);  // Simulate time taken to read
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

