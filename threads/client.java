package threads;

public class client {

    public static void dosomething(){
        System.out.println("heeloo for parent " +" Thread  : " + Thread.currentThread().getName()) ;
    }
    public static void main(String[]args){
        
        for(int i=0;i<100000;i++){
            NumberPrinter np=new NumberPrinter(i);
            Thread t=new Thread(np);
            t.start();
        }
        // HelloWorldPrinter hw=new HelloWorldPrinter();
        // Thread t=new Thread(hw);
        // t.start();
        // dosomething();

    }
    /*
     * Create a class for task lets take helper class
     * Create helper class object in main
     * pass that helper class object to thread class obj
     * t.start()
     */
}

