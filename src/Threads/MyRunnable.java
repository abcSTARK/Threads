package Threads;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("In Run Name : " + Thread.currentThread().getName());
    }

    public static void main(String args[]) {
        Runnable r = new MyRunnable();
        //r.start();
        Thread t = new Thread(r);
        t.start();
    }
}
