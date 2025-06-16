package ReaderWriter;

public class client {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Start some readers and writers
        for (int i = 1; i <= 3; i++) {
            new Reader(i, counter).start();
        }

        for (int i = 1; i <= 2; i++) {
            new Writer(i, counter).start();
        }
    }
}

