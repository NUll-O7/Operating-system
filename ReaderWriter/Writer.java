package ReaderWriter;

public class Writer extends Thread {
    private final int id;
    private final Counter counter;

    public Writer(int id, Counter counter) {
        this.id = id;
        this.counter = counter;
    }

    public void run() {
        int value = (int)(Math.random() * 100);  // generate random value
        System.out.println("Writer " + id + " is writing value: " + value);
        counter.write(value);
        try {
            Thread.sleep(1000);  // Simulate time taken to write
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}