package MergeSortThreaded;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = List.of(8, 1 , 6 , 2 , 3 , 9 ,7 , 5);
        
        Sorter <List<Integer>>arraySorter=new Sorter(list);
        ExecutorService ex=Executors.newFixedThreadPool(4);

        Future<List<Integer>>sortedarrayFuture=ex.submit(arraySorter);
        List<Integer>sortedarray=sortedarrayFuture.get();
        System.out.println(sortedarray);
    }
}
