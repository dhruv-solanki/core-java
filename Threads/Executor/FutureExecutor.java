package Threads.Executor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

class RunnableTask implements Runnable {
    @Override
    public void run() {
        System.out.println("This is runnable task!");
    }
}

class CallableTask implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("This is callable task!");
        return null;
    }
}

public class FutureExecutor {
    public static void singleFutureMethod(ExecutorService executorService) throws ExecutionException, InterruptedException {
        Future<Integer> future = executorService.submit(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Thread started...");
            } catch (CancellationException | InterruptedException e) {
                System.out.println(e);
                Thread.currentThread().interrupt();
            }
            System.out.println("Reached the end!");
            return 42;
        });
        System.out.println("Getting future...");
//        stop the thread execution whether it started or not
//        future.cancel(true);
//        stop the thread execution only if not started, isCancelled and isDone will be still true
//        but the thread will be running
        future.cancel(false);
        System.out.println(future.isCancelled());
        System.out.println(future.isDone());
//        try {
//            System.out.println(future.get(1, TimeUnit.SECONDS));
//        } catch (CancellationException | TimeoutException e) {
//            System.out.println(e);
//        }
    }

    public static void runnableCallableMethod(ExecutorService executorService) {
        //        use runnable when just want to run the code
        executorService.submit(new RunnableTask());

//        use callable when want to return the result
        Future<?> submit = executorService.submit(new CallableTask());
    }

    public static void multipleFutureMethod(ExecutorService executorService) {
        Callable<Integer> callable1 = () -> {
            Thread.sleep(1000);
            System.out.println("Callable 1");
            return 100;
        };
        Callable<Integer> callable2 = () -> {
            Thread.sleep(1000);
            System.out.println("Callable 2");
            return 200;
        };
        Callable<Integer> callable3 = () -> {
            Thread.sleep(1000);
            System.out.println("Callable 3");
            return 300;
        };

        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);

        List<Future<Integer>> futures = null;
        try {
//            futures = executorService.invokeAll(list);
//            wait for some specified time and stops all other threads after that time
            futures = executorService.invokeAll(list, 2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        for(Future<Integer> f: futures) {
            try {
                System.out.println(f.get());
            } catch (CancellationException | InterruptedException | ExecutionException e) {
                System.out.println(e);
            }
        }

//        runs tasks that depends on thread but returns result of only one thread
        try {
            Integer i = executorService.invokeAny(list);
            System.out.println(i);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }

        System.out.println("All callable finished their task!");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        singleFutureMethod(executorService);

//        runnableCallableMethod(executorService);

//        multipleFutureMethod(executorService);

        executorService.shutdown();
    }

}
