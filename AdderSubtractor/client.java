package AdderSubtractor;

public class client {
    public static void main(String[]args) throws InterruptedException {
        Count count=new Count(0);

        Adder ad=new Adder(count);
        Subtractor sub=new Subtractor(count);

        Thread t1=new Thread(ad);
        Thread t2=new Thread(sub);

        t1.start();
        t2.start();

        t1.join(); // main thread will stop execution and waits for t1 to finish
        t2.join(); //main thread will stop until t2 is done

        System.out.println(count.value);
    }

}
