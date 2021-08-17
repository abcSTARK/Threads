package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoExecutors {
    public static void main(String args[]){

        ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Name : " + Thread.currentThread().getName());
            }
        });
        service.execute(()->{System.out.println("Hello from Thread , Name : " + Thread.currentThread().getName());});
        service.shutdown();
    }
}
