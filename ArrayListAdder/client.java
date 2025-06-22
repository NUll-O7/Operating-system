package ArrayListAdder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class client {
    public static void main(String[] args) {
        List<Integer> sharedList = new CopyOnWriteArrayList<>();
        // List<Integer> sharedList=new ArrayList<>(); 

        InserterThread1 thread1 = new InserterThread1(sharedList);
        InserterThread2 thread2 = new InserterThread2(sharedList);

        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the size of the ArrayList
        System.out.println("Expected size: 2000");
        System.out.println("Actual size: " + sharedList.size());
    }
}




int solve(){
    //Lets say we have a pair consisting of val,wt,idx and now i want to write create a priorityqueue 
    //which return the element with least wt first

    PriorityQueue<pair> pq=new PriorityQueue<>(new logic());

    while(pq.size()>0){
        pair rem=pq.remove(); //this will extract one with minimum wt
    }
}
class logic implements Comparator<pair>{
    public int compare (pair a, pair b){
        if(a.wt<b.wt) return -1;
        else if(a.wt>b.wt) return 1;
        else return 0;
    }
}
