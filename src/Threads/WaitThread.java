package Threads;

public class WaitThread {
    public static void main(String args[]){
        System.out.println("In Main Name : "+ Thread.currentThread().getName());

        NotifyThread thread = new NotifyThread(12,12);
        thread.start();
        try {
            synchronized (thread) {
                thread.wait();
                System.out.println("Total Value : " + thread.total);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
