package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class client {
    public static void main(String[]args){

        ExecutorService ex =  Executors.newFixedThreadPool(10);

        for(int i=0;i<1000000;i++){
            NumberPrinter np=new NumberPrinter(i);
            ex.execute(np);
        }
        
    }
}
