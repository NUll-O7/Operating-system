package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class client {
    public static void main(String[]args){

        ExecutorService ex =  Executors.newFixedThreadPool(5);
        //  ExecutorService ex =  Executors.newCachedThreadPool(); 
        //  CachedThreadPool is  used where we don't define fix number of threads,
        //  it wiull be handled by executor where it will create new threads when all of the thread
        // are occupied 

        for(int i=0;i<1000000;i++){
            NumberPrinter np=new NumberPrinter(i);
            ex.execute(np);
        }
        
    }
}
