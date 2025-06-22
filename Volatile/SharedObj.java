package Volatile;

public class SharedObj {
    volatile boolean flag=false;

    public void setFlagTrue(){
        flag=true;
    }

    public void printifFlagTrue(){
        while(flag==false){
            //do nothing
        }
        System.out.println("Reader read this flag as true");
    }
}
