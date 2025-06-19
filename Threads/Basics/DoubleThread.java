package Threads.Basics;

public class DoubleThread extends Thread {
    public DoubleThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running...");
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        DoubleThread t1 = new DoubleThread("T1");
        DoubleThread t2 = new DoubleThread("T2");
        t1.start();
        t2.start();
    }
}
