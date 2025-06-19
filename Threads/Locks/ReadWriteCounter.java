package Threads.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    private int count = 0;

    public void increment() {
        writeLock.lock();
        try {
            count++;
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println(e);
            Thread.currentThread().interrupt();
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount() {
        readLock.lock();
        try {
            return count;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteCounter counter = new ReadWriteCounter();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<5; i++) {
                    System.out.println(Thread.currentThread().getName() + " read: " + counter.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<5; i++) {
                    counter.increment();
                    System.out.println(Thread.currentThread().getName() + " counter incremented!");
                }
            }
        };

        Thread writer1Thread = new Thread(writeTask, "Writer1");
        Thread writer2Thread = new Thread(writeTask, "Writer2");
        Thread reader1Thread = new Thread(readTask, "Reader1");
        Thread reader2Thread = new Thread(readTask, "Reader2");

        writer1Thread.start();
        writer2Thread.start();
        reader1Thread.start();
        reader2Thread.start();

        writer1Thread.join();
        writer2Thread.join();
        reader1Thread.join();
        reader2Thread.join();

        System.out.println("Final count: " + counter.getCount());
    }
}
