package Deadlock;

public class TransferTask1 implements Runnable {
    private final Account account1;
    private final Account account2;
    private final double amount;

    public TransferTask1(Account account1, Account account2, double amount) {
        this.account1 = account1;
        this.account2 = account2;
        this.amount = amount;
    }

    @Override
    public void run() {
        System.out.println("Task 1: Starting transfer from " + account1.getAccountId() + " to " + account2.getAccountId());
        synchronized (account1) {
            System.out.println("Task 1: Locked " + account1.getAccountId());
            try {
                Thread.sleep(1000); // Simulate processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task 1: Waiting to lock " + account2.getAccountId());
            synchronized (account2) {
                System.out.println("Task 1: Locked " + account2.getAccountId());
                account1.updateBalance(-amount);
                account2.updateBalance(amount);
                System.out.println("Task 1: Completed transfer. " + account1.getAccountId() + " balance: " + account1.getBalance() + ", " + account2.getAccountId() + " balance: " + account2.getBalance());
            }
        }
    }
}