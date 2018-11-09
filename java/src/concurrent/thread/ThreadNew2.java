package concurrent.thread;

public class ThreadNew2 extends Thread{

    private Add add;

    public ThreadNew2(Add add){
        this.add = add;
    }

    @Override
    public void run() {
        add.add();
        System.out.println(" Thread New2 ");
    }
}
