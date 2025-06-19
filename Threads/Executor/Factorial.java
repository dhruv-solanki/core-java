package Threads.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Factorial {
    public static void findFactorialWithThreads() {
        long startTime = System.currentTimeMillis();
        Thread[] t = new Thread[10];
        for(int i=1; i<=10; i++) {
            int finalI = i;
//            creating new threads and putting into array
            t[i-1] = new Thread(() -> {
                long res = factorial(finalI);
                System.out.printf("Factorial of %d: %d%n", finalI, res);
            });
            t[i-1].start();
        }
//        waiting for those threads to finish their work
        for(Thread thread: t) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e);
                Thread.currentThread().interrupt();
            }
        }

        long endTime = System.currentTimeMillis();
        float timeTaken = (float)(endTime - startTime) / 1000;
        System.out.println("Time finished: " + timeTaken + " sec");
    }

    public static void findFactorialWithThreadPool() {
        long startTime = System.currentTimeMillis();

//        creating thread pool of size 3
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i=1; i<=10; i++) {
            int finalI = i;
//            submit the runnable instance in which run method should run
            executor.submit(() -> {
                long res = factorial(finalI);
                System.out.printf("Factorial of %d: %d%n", finalI, res);
            });
        }

//        shutdown the thread pool so it can be used again later whenever needed
        executor.shutdown();

//        wait for all threads to complete their work
        try {
//            wait for at least 100 seconds until you move on with next lines
            executor.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println(e);
            Thread.currentThread().interrupt();
        }

        long endTime = System.currentTimeMillis();
        float timeTaken = (float)(endTime - startTime) / 1000;
        System.out.println("Time finished: " + timeTaken + " sec");
    }

    public static void main(String[] args) {
        findFactorialWithThreadPool();
    }

    public static long factorial(int n) {
        long res = 1;
        for(int i=1; i<=n; i++) {
            try {
                res *= i;
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        return res;
    }
}
