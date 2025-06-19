package Threads.Executor;

import java.util.concurrent.*;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int numOfServices = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numOfServices);
//        it waits for all threads to arrive at particular point where you have written barrier.await()
//        when all the parties will reach that point it will move forward
//        the second param here is the method run of Runnable interface
//        it will be executed one all the thread reach the tipping point (last point)
//        when to use: when you want to perform particular task when all the threads(parties) reach or complete
//        particular task
//        Bonus: we can also do matrix multiplication with help of cyclic barrier
        CyclicBarrier barrier = new CyclicBarrier(numOfServices, () -> {
            System.out.println("Every thread now reached the tipping point!");
        });

        executorService.submit(new DependentService2(barrier));
        executorService.submit(new DependentService2(barrier));
        executorService.submit(new DependentService2(barrier));

//        cyclic barrier does not block main thread so this line will run first
        System.out.println("All services completed!");
//        we can also reset the barrier count
//        barrier.reset();
        executorService.shutdown();
    }

}

class DependentService2 implements Callable<String> {
    private final CyclicBarrier barrier;

    public DependentService2(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " service started.");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " waiting at the barrier.");
//            waiting for other threads(parties) to arrive at this point
//            meanwhile current thread will become dormant
        barrier.await();
        return "ok";
    }
}
