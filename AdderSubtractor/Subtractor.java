package AdderSubtractor;

public class Subtractor implements Runnable{
    public Count count;

    public Subtractor(Count c){
        count=c;
    }

    public void run(){
        for(int i=0;i<=100000;i++){
            count.value-=i;
        }
    }
}
