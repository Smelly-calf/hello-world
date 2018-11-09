package concurrent.thread;

public class Add {
    public int sum = 0;
    public void add(){
        try {
            Thread.sleep(50L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sum += 1;
        System.out.println( "累计"+sum);
    }
}
