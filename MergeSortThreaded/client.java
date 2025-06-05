package MergeSortThreaded;

import java.util.*;
import java.util.concurrent.*;

public class client{
    public static void main(String[]args) throws ExecutionException, InterruptedException{
        List<Integer> list = List.of(8, 1 , 6 , 2 , 3 , 9 ,7 , 5);
        ExecutorService ex = Executors.newFixedThreadPool(7);
        Sorter arraySorter = new Sorter(list);


        Future<List<Integer>> arrayFuture =  ex.submit(arraySorter);
        List<Integer> x =  arrayFuture.get();
        System.out.println(x);
    }
}