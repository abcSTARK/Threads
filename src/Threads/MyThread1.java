package Threads;

public class MyThread1 extends Thread{
    @Override
    public void run() {
        //super.run();
        try {
            for(int i=0;i<5;i++){

                System.out.println(i);
                Thread.sleep(3000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("In Run Method : "+ Thread.currentThread().getName());
    }
    public static void main(String args[]){

        System.out.println("In Main Method : "+ Thread.currentThread().getName());
        Thread t=new MyThread1();
        //t.run();
        t.start();

        System.out.println("At the end of Main Method : "+ Thread.currentThread().getName());

    }
}
