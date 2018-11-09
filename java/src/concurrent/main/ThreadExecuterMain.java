package concurrent.main;

import concurrent.thread.Add;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecuterMain {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadExecuterMain threadExecuterMain = new ThreadExecuterMain();
        final Add add = new Add();
  /*      List<String> list = new ArrayList<String>();
        for(int i=0;i<100;i++){
            list.add(i+"a");
        }
        for(int i=0 ;i <1;i++){
            threadExecuterMain.threadExecture2(list);
        }
       final Add add = new Add();*/
        for(int i=0; i< 1000;i++ ){
            final int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().setName("Thread i = " + index);
                    System.out.println(Thread.currentThread().getName() + " index = " + index);

                    add.add();
/*
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                }
            });

        }

        executorService.shutdown();
        System.out.println("结果：" + add.sum);

    }

  /*  public  void threadExecture(Add add){
        executorService.execute(new ThreadNew2(add));
    }

    public void threadExecture2(List<String> list){
        executorService.execute(new ThreadNew(list));
    }*/
}
