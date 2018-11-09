package concurrent.thread;

import java.util.List;

public class ThreadNew implements Runnable {

    private List<String> list;

    public ThreadNew(){}

    public ThreadNew(List<String> list){
        this.list = list;
    }

    @Override
    public void run() {
        for(int i=0;i<list.size();i++){
            Thread.currentThread().setName("a"+i);
            System.out.println(Thread.currentThread().getName() +"  "+i);
        }
        // System.out.println("  Thread New  ");
    }
}
