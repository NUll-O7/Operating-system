package AdderSubtractor;

public class Adder implements Runnable{
    public Count count;

    public Adder(Count c){
        count=c;
    }
    public void run(){
        for(int i=1;i<=100000;i++){
            count.value+=i;
        }
    }
    
}
