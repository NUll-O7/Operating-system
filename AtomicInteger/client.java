package AtomicInteger;

public class client {
    public static void main(String[]args){
        SharedCounter sc=new SharedCounter();

        ThreadTask1 tt=new ThreadTask1(sc);
        ThreadTask2 to=new ThreadTask2(sc);

        Thread t1=new Thread(tt);
        Thread t2=new Thread(to);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sc.getCounter());

    }
}
