package Threads.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
//    it is keeping count that how many times the lock was acquired
//    and also keep count that how many times it was unlocked
//    here it seems that it will be going into deadlock
//    since outerMethod acquired the lock and then called innerMethod
//    and innerMethod is also acquiring the lock
//    but instead of deadlock it will work
//    because it is main thread that acquired in the first place
//    so it will increment the count and move on
//    and same with unlock, when innerMethod unlocks
//    that doesn't mean other thread can access outerMethod
//    it will decrement the count
//    and when it will match with original lock count it will release the lock
    private final Lock lock = new ReentrantLock();

    public void outerMethod() {
        lock.lock();
        try {
            System.out.println("Outer method");
            innerMethod();
        } finally {
            lock.unlock();
        }
    }

    public void innerMethod() {
        lock.lock();
        try {
            System.out.println("Inner method");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantExample re = new ReentrantExample();
        re.outerMethod();
    }
}
