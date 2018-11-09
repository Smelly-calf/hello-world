package concurrent.thread;

import java.util.concurrent.Callable;

public class ThreadNew3 implements Callable<String> {
    public String call() throws Exception {

        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" Thread New3  ");
        return "Thread New3 Result";
    }
}
