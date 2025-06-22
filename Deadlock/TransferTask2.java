package Deadlock;

public class TransferTask2 implements Runnable {
    private final Account account1;
    private final Account account2;
    private final double amount;

    public TransferTask2(Account account1, Account account2, double amount) {
        this.account1 = account1;
        this.account2 = account2;
        this.amount = amount;
    }

    @Override
    public void run() {
        System.out.println("Task 2: Starting transfer from " + account2.getAccountId() + " to " + account1.getAccountId());
        synchronized (account2) {
            System.out.println("Task 2: Locked " + account2.getAccountId());
            try {
                Thread.sleep(1000); // Simulate processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task 2: Waiting to lock " + account1.getAccountId());
            synchronized (account1) {
                System.out.println("Task 2: Locked " + account1.getAccountId());
                account2.updateBalance(-amount);
                account1.updateBalance(amount);
                System.out.println("Task 2: Completed transfer. " + account1.getAccountId() + " balance: " + account1.getBalance() + ", " + account2.getAccountId() + " balance: " + account2.getBalance());
            }
        }
    }
}