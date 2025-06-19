package Threads.Basics;

public class DaemonThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Daemon Thread running...");
        }
    }

    public static void main(String[] args) {
        DaemonThread dm = new DaemonThread();
//        JVM does not wait for daemon thread
        dm.setDaemon(true);
        dm.start();
        System.out.println("Main is done!");
    }
}
