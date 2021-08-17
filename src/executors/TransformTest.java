package executors;

import java.util.concurrent.RecursiveAction;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class TransformTest {

    static final int SIZE = 10_000_000;
    static int[] array = randomArray();

    public static void main(String[] args) {

        int number = 9;
        System.out.println("First 10 elements of the array before: ");
        print();

        Transforms mainTask = new Transforms(array, number, 0, SIZE);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);

        System.out.println("First 10 elements of the array after: ");
        print();
    }
    static int[] randomArray() {
        int[] array = new int[SIZE];
        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }

    static void print() {
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

}
