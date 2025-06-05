package MergeSortThreaded;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>>{
    List<Integer>arrayToSort;

    public Sorter(List<Integer>al){
        arrayToSort=al;
    }

    public List<Integer> call() throws Exception{
        if(arrayToSort.size()==1) return arrayToSort;

        int mid=arrayToSort.size()/2;

        List<Integer>leftArray=new ArrayList<>();
        List<Integer>rightArray=new ArrayList<>();

        for(int i=0;i<mid;i++){
            leftArray.add(arrayToSort.get(i));
        }
        for(int i=mid;i<arrayToSort.size();i++){
            rightArray.add(arrayToSort.get(i));
        }
        Sorter leftArraySorter=new Sorter(leftArray);
        Sorter rightArraySorter=new Sorter(rightArray);

        ExecutorService ex=Executors.newCachedThreadPool();

        Future<List<Integer>>leftArrayFuture=ex.submit(leftArraySorter);
        Future<List<Integer>>rightArrayFuture=ex.submit(rightArraySorter);

        List<Integer>sortedLeftArray=leftArrayFuture.get();
        List<Integer>sortedRightArray=rightArrayFuture.get();

        List<Integer>ans=new ArrayList<>();
        int i=0,j=0;
        
        while(i<sortedLeftArray.size() && j<sortedRightArray.size()){
            if(sortedLeftArray.get(i)<=sortedRightArray.get(j)){
                    ans.add(sortedLeftArray.get(i));
                    i++;
            }else{
                ans.add(sortedRightArray.get(j));
                j++;
            }
        }
        while(i<sortedLeftArray.size()){
            ans.add(sortedLeftArray.get(i));
                i++;
        }
        while(j<sortedRightArray.size()){
            ans.add(sortedRightArray.get(j));
                j++;
        }
        return ans;
    }
    
}
