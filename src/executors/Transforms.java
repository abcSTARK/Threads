package executors;

import java.util.concurrent.RecursiveAction;

public class Transforms extends RecursiveAction {
    int[] array;
    int number;
    int threshold = 100_000;
    int start;
    int end;

    public Transforms(int[] array, int number, int start, int end) {
        this.array = array;
        this.number = number;
        this.start = start;
        this.end = end;
    }

    protected void compute() {
        System.out.println(Thread.currentThread().getName());
        if (end - start < threshold) {
            computeDirectly();
        } else {
            int middle = (end + start) / 2;

            Transforms subTask1 = new Transforms(array, number, start, middle);
            Transforms subTask2 = new Transforms(array, number, middle, end);

            invokeAll(subTask1, subTask2);
        }
    }
    protected void computeDirectly() {
        for (int i = start; i < end; i++) {
            array[i] = array[i] * number;
        }
    }
}
