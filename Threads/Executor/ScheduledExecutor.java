package Threads.Executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//        scheduler.schedule(() -> System.out.println("Task executed after 3 sec delay!"), 3, TimeUnit.SECONDS);
//        scheduler.shutdown();

//        scheduler.scheduleAtFixedRate(
//                () -> System.out.println("scheduleAtFixedRate: Task executed after every 3 sec delay!"),
//                3,
//                3,
//                TimeUnit.SECONDS
//        );

        scheduler.scheduleWithFixedDelay(
                () -> {
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                    System.out.println("scheduleWithFixedDelay: Task executed after every 3 sec delay!");
                },
                3,
                3,
                TimeUnit.SECONDS
        );

        scheduler.schedule(() -> {
            System.out.println("Initiating shutdown...");
            scheduler.shutdown();
        }, 9, TimeUnit.SECONDS);
    }
}
