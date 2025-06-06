package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class client {
    public static void main(String[]args){

        ExecutorService ex =  Executors.newCachedThreadPool();
        //  ExecutorService ex =  Executors.newCachedThreadPool(); 
        //  CachedThreadPool is  used where we don't define fix number of threads,
        //  it will be handled by executor where it will create new 
        //threads if all existing threads are occupied 
        for(int i=1;i<=100000;i++){
            NumberPrinter np=new NumberPrinter(i);
            ex.execute(np);
        }
        ex.shutdown();
        
    }
}
