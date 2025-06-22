package Volatile;
import java.util.*;

public class client{
    public static void main(String[]args){
        SharedObj shared=new SharedObj();

        ReaderTask rd=new ReaderTask(shared);
        WriterTask wt=new WriterTask(shared);

        Thread writer=new Thread(wt);
        Thread reader=new Thread(rd);

        reader.start();
        writer.start();
    }
}