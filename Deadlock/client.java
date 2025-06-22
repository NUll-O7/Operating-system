package Deadlock;

public class client {
    public static void main(String[] args) {
        // Create two bank accounts
        Account account1 = new Account("Account-1", 1000.0);
        Account account2 = new Account("Account-2", 1000.0);

        // Create transfer tasks
        TransferTask1 task1 = new TransferTask1(account1, account2, 100.0);
        TransferTask2 task2 = new TransferTask2(account1, account2, 50.0);

        // Create and start threads
        Thread thread1 = new Thread(task1, "Thread 1");
        Thread thread2 = new Thread(task2, "Thread 2");

        thread1.start();
        thread2.start();
    }
}
