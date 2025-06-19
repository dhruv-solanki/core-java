package Threads.Basics;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("RUNNING");
        System.out.println("From run - Thread Name: " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
//        NEW
        System.out.println(t1.getState());
        t1.start();
//        RUNNABLE / RUNNING
        System.out.println(t1.getState());
        Thread.sleep(1000);
//        TIMED_WAITING
        System.out.println(t1.getState());
        t1.join();
//        TERMINATED
        System.out.println(t1.getState());

        System.out.println("From main - Thread Name: " + Thread.currentThread().getName());
    }
}
