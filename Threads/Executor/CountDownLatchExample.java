package Threads.Executor;

import java.util.concurrent.*;

public class CountDownLatchExample {
//    public static void waitWithoutCountDownLatch() {
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        Future<String> future1 = executorService.submit(new DependentService());
//        Future<String> future2 = executorService.submit(new DependentService());
//        Future<String> future3 = executorService.submit(new DependentService());
//
//        try {
//            future1.get();
//            future2.get();
//            future3.get();
//        } catch (InterruptedException | ExecutionException e) {
//            System.out.println(e);
//        }
//
//        System.out.println("All services finished!");
//        executorService.shutdown();
//    }

    public static void main(String[] args) {
        int numOfServices = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numOfServices);
//        we are giving how many threads to wait for to complete their job
//        it is count down means it counting down, starts from 3 then 2 then 1 and then finally 0.
//        we can also use this latch with normal thread as well without executor service
//        when to use: when we have to wait for multiple threads to finish their job and then proceed next
//        when to not use: when we need reusability, because countdown latch is not reusable, we can't reset count
        CountDownLatch latch = new CountDownLatch(numOfServices);

        executorService.submit(new DependentService1(latch));
        executorService.submit(new DependentService1(latch));
        executorService.submit(new DependentService1(latch));

        try {
//            it waits here for all the thread arrive with their result
//            and when final thread comes with the result it will move on with next line
            latch.await();
//            it waits for specified period of time and then move on with next line of code
//            latch.await(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("All services completed!");
        executorService.shutdown();
    }

}

class DependentService1 implements Callable<String> {
    private final CountDownLatch latch;

    public DependentService1(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + " service started.");
            Thread.sleep(2000);
        } finally {
//            we are decrementing the counter value here when thread finish its job
            latch.countDown();
        }
        return "ok";
    }
}
