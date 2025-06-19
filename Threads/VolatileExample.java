package Threads;

class SharedObj {
    private volatile boolean flag = false;

    public void setFlagTrue() {
        System.out.println("Writer thread made flag true!");
        flag = true;
    }

//    here reader thread is reading value flag, which will be set = true
//    after 2 sec delay but even after that reader thread will be stuck in loop
//    because every thread uses cache variables
//    so we have set obj variable true and in RAM it is changed
//    but reader thread is reading value from cached variable
//    so it will be stuck in loop
    public void printIfFlagTrue() {
        while(!flag) {
//            System.out.println("Reader thread stuck in loop...");
        }
        System.out.println("Reader thread read the flag true!");
    }
}

public class VolatileExample {
    public static void main(String[] args) {
        SharedObj obj = new SharedObj();
//    writer thread will set flag = true but after 2 sec
//    because we want the CPU to pick reader thread first
        Thread writerThread = new Thread(() -> {
            System.out.println("Writer thread started!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            obj.setFlagTrue();
        });
        Thread readerThread = new Thread(() -> {
            System.out.println("Reader thread started!");
            obj.printIfFlagTrue();
        });

        writerThread.start();
        readerThread.start();
    }
}
