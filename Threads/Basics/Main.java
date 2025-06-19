package Threads.Basics;

public class Main {
    public static void main(String[] args) {
//        extends Thread class
        World w = new World();
        w.start();

//        implements Runnable interface
        Duck d = new Duck();
        Thread t1 = new Thread(d);
        t1.start();

        for (int i=0; i<10000; i++) {
            System.out.println("Helloooooooo");
        }
    }
}
