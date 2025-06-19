package Threads;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
//    we can use synchronized in method to achieve same result each time for both threads,
//    but we can also use AtomicInteger or other AtomicClassName objects that gives us atomic operation
//    without using any synchronized or locks
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicCounter ac = new AtomicCounter();
        Thread t1 = new Thread(() -> {
            for(int i=0; i<10000; i++) {
                ac.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i=0; i<10000; i++) {
                ac.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(ac.getCount());
    }
}
