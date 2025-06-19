package Threads.Basics;

public class FishThread extends Thread {
    public FishThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("I am Fish Thread!");
        } catch(InterruptedException e) {
            System.out.println("Thread Interrupted: " + e);
        }
    }

    public static void main(String[] args) {
        FishThread f = new FishThread("fish");
        f.start();
        f.interrupt();
    }
}
