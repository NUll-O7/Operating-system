package DiningPhilospher;

import java.util.*;
import java.util.concurrent.*;

class Philosopher implements Runnable {
    private final int id;
    private final Chopstick leftChopstick;
    private final Chopstick rightChopstick;
    private final Semaphore commonDiningSemaphore; // Limits concurrent access to dining
    private final Semaphore[] chopstickSemaphores; // Semaphores for each chopstick
    private final Random random;
    private int eatCount;
    private static final int MAX_EAT_COUNT = 5;

    public Philosopher(int id,
                       Chopstick leftChopstick,
                       Chopstick rightChopstick,
                       Semaphore commonDiningSemaphore,
                       Semaphore[] chopstickSemaphores) {
        this.id = id;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
        this.commonDiningSemaphore = commonDiningSemaphore;
        this.chopstickSemaphores = chopstickSemaphores;
        this.random = new Random();
        this.eatCount = 0;
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking.");
        Thread.sleep(random.nextInt(1000) + 500); // Think for 0.5 to 1.5 seconds
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " is eating.");
        Thread.sleep(random.nextInt(1000) + 500); // Eat for 0.5 to 1.5 seconds
        eatCount++;
    }

    @Override
    public void run() {
        while (eatCount < MAX_EAT_COUNT) {
            try {
                think();

                System.out.println("Philosopher " + id + " is hungry and waiting to enter dining area.");
                commonDiningSemaphore.acquire(); // Acquire a permit to enter the "dining area"

                System.out.println("Philosopher " + id + " entered dining area, trying to pick up chopsticks.");

                // Acquire left chopstick
                chopstickSemaphores[leftChopstick.getId()].acquire();
                System.out.println("Philosopher " + id + " picked up " + leftChopstick);

                // Acquire right chopstick
                chopstickSemaphores[rightChopstick.getId()].acquire();
                System.out.println("Philosopher " + id + " picked up " + rightChopstick);

                // Now both chopsticks are held, the philosopher can eat
                eat();
                System.out.println("Philosopher " + id + " finished eating. Eat count: " + eatCount);

                // Release chopsticks in reverse order (or any order, as they are independent)
                chopstickSemaphores[rightChopstick.getId()].release();
                

                chopstickSemaphores[leftChopstick.getId()].release();
                

                commonDiningSemaphore.release(); // Release the permit to leave the "dining area"
                System.out.println("Philosopher " + id + " left dining area.");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Philosopher " + id + " was interrupted.");
                return; // Exit the run method
            }
        }
        System.out.println("Philosopher " + id + " has eaten " + MAX_EAT_COUNT + " times and is satisfied.");
    }
}