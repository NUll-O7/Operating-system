package DiningPhilospher;

import java.util.*;
import java.util.concurrent.*;

public class client {
    private static final int NUM_PHILOSOPHERS = 5;

    public static void main(String[] args) {

        // Semaphore for each chopstick, initialized with 1 permit (available)
        Semaphore[] chopstickSemaphores = new Semaphore[NUM_PHILOSOPHERS];
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            chopstickSemaphores[i] = new Semaphore(1);
        }

        // Logical Chopstick objects (no internal locking needed here)
        Chopstick[] chopsticks = new Chopstick[NUM_PHILOSOPHERS];
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            chopsticks[i] = new Chopstick(i);
        }

        // Common Dining Semaphore: Allows at most N-1 philosophers to enter the critical section
        // where they attempt to pick up chopsticks. This prevents deadlock.
        Semaphore commonDiningSemaphore = new Semaphore(NUM_PHILOSOPHERS - 1); // Crucial for deadlock prevention
        
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            Chopstick leftChopstick = chopsticks[i];
            Chopstick rightChopstick = chopsticks[(i + 1) % NUM_PHILOSOPHERS];

            // Create a new Philosopher instance
            Philosopher philosopher = new Philosopher(i, leftChopstick, rightChopstick,
                                                     commonDiningSemaphore, chopstickSemaphores);

            // Create a new Thread for this philosopher and start it immediately
            Thread philosopherThread = new Thread(philosopher, "Philosopher-" + i);
            philosopherThread.start();
        }

        try {
            System.out.println("\nMain thread sleeping, allowing philosophers to run...");
            Thread.sleep(20000); // Let the simulation run for 20 seconds
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

    }
}