package executors;
import java.util.*;
import java.util.concurrent.*;

public class DemoCallable {
    public static void main(String args[]) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        Future<Integer> future = service.submit(()->{
            return 1000;
        });

        try {
            int ans = future.get();
            System.out.println("ans:- "+ans);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        List<Callable<String>> callables = Arrays.asList(
                ()->"task1",()->"task2",()->"Java",()->"callable"
        );

        service.invokeAll(callables).stream().map(fut -> {
        try {
             return fut.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
            return null;
        }).forEach(System.out::println);

        service.shutdown();
    }
}
