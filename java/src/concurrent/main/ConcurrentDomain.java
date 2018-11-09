package concurrent.main;

import java.util.concurrent.Callable;

public class ConcurrentDomain implements Callable<Integer> {

    private int number;

    public ConcurrentDomain(int number) {
        this.number = number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {

        return number;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(number);
        return 1;
    }
}
