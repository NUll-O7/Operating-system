package Volatile;
public class WriterTask  implements Runnable{
    private final SharedObj shared;

    public WriterTask(SharedObj s){
        shared=s;
    }
    public void run(){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            return;
        }
        shared.setFlagTrue();
        System.out.println("Writer made the flag true");
    }
}
