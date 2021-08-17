package Threads;

public class NotifyThread extends Thread{
    public static int total =0;
    private int x,y;

    public NotifyThread(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public void run() {
        //super.run();
        System.out.println("In Run Name : " + Thread.currentThread().getName());
        synchronized (this) {
            total = x + y;
            notify();
        }
    }
}
