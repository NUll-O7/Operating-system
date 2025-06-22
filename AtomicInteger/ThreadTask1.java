package AtomicInteger;

public class ThreadTask1 implements Runnable{
    private  SharedCounter sc;

    public ThreadTask1(SharedCounter s){
        sc=s;
    }

    public void run(){
        for(int i=1;i<=1000;i++){
            sc.increment();
        }
    }
}
