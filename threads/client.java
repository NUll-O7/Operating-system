package threads;

public class client {

    public static void doSomething(){
        System.out.println("hi from parent " + " Thread : " + Thread.currentThread().getName());
    }
    public static void main(String[]args){
        // HelloWorldPrinter hw=new HelloWorldPrinter();
        // Thread t=new Thread(hw);
        // t.start();
        // doSomething();

        for(int i=1;i<=100;i++){
            NumberPrinter np=new NumberPrinter(i);
            Thread t=new Thread(np);
            t.start();
        }
        }

    }

