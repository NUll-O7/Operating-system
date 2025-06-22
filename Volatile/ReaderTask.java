package Volatile;
public class ReaderTask implements Runnable{
    private final SharedObj shared;

    public ReaderTask(SharedObj s){
        shared=s;
    }

    public void run(){
        shared.printifFlagTrue();
    }
}
