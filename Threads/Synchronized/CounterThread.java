package Threads.Synchronized;

// Disadvantages:
// 1 - Unfairness
// 2 - Blocking
// 3 - Not - Interruptibly
// 4 - Unable to differentiate Read / Write

public class CounterThread extends Thread {
    private Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0; i<10000; i++) {
            counter.increment();
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
//        counter is shared resource between 2 threads
//        this can lead to race condition
//        and will give unpredictable results
//        output should be always: 20000
//        but it will give different result always
//        to prevent this use synchronized
        CounterThread t1 = new CounterThread(counter);
        CounterThread t2 = new CounterThread(counter);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(counter.getCount());
    }
}
