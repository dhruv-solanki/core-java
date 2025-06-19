package Threads.Locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    public void withDraw(int amount) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " attempting to withdraw: " + amount);
        try {
            if(lock.tryLock(4000, TimeUnit.MILLISECONDS)) {
                if(balance >= amount) {
                    System.out.println(threadName + " proceeding with withdrawal");
                    try {
                        Thread.sleep(5000);
                        balance -= amount;
                        System.out.println(threadName + " completed withdrawal. Remaining Balance: " + balance);
                    } catch(InterruptedException e) {
                        System.out.println(e);
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(threadName + " insufficient balance!");
                }
            } else {
                System.out.println(threadName + " could not acquire lock! Try again later!");
            }
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
