package Threads;

public class DemoPriority extends Thread{
    @Override
    public void run() {
        //super.run();
        System.out.println("In Run Method : "+ Thread.currentThread().getName());
    }
    public static void main(String args[]){

        System.out.println("In Main Method : "+ Thread.currentThread().getName());
        Thread t=new DemoPriority();
        //t.run();
        t.setName("priority thread");
        t.setPriority(MAX_PRIORITY);// doesn't really prioritize
        t.start();

        System.out.println("At the end of Main Method : "+ Thread.currentThread().getName());

    }
}
