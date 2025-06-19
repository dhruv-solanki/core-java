package Threads.Synchronized;

public class Counter {
    private int count = 0;

//    this is critical section because it is accessed by two threads simultaneously
//    it is also called race condition, because two threads are sharing same resource
//    to prevent this we can use synchronized method or block
//    the prevention is also called mutual exclusion
//    that means only one thread can access this method at a time
//    meanwhile other thread will wait
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
