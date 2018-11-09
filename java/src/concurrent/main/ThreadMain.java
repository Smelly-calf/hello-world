package concurrent.main;

import concurrent.thread.Add;
import concurrent.thread.ThreadNew2;

import java.util.ArrayList;
import java.util.List;

public class ThreadMain {
    public static void main(String[] args) {
    /*    ThreadNew threadNew = new ThreadNew();
        threadNew.run();

        FutureTask<String> futureTask = new FutureTask<String>(new ThreadNew3());

        new Thread(futureTask).start();

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
*/
        Add add = new Add();
        for(int i=0; i< 5;i++){
            new ThreadNew2(add).start();
        }

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最后的值：" + add.sum);
        ArrayList<Integer> integers = new ArrayList<Integer>();
        for(int i=0;i < 5000;i++){
            integers.add(i);
        }
       /*   integers.add(5);
        integers.add(5);
        integers.add(5);integers.add(5);
        integers.add(5);integers.add(5);integers.add(5);*/
        integers.remove(1);
        integers.remove(2);

        List<Integer> integers1 = null;
        for(int i=0;i< integers.size();i+=500){
            if(i+500 < integers.size()){
                integers1 = integers.subList(i,i+500);
            }else{
                integers1 = integers.subList(i, integers.size());
            }

            System.out.println(integers1.size());
        }
    }
}
