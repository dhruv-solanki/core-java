package Threads.Basics;

public class DuckThread extends Thread {
    public DuckThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i=0; i<5; i++) {
            String a = "";
            for(int j=0; j<10000; j++) {
                a += Math.pow(j, j);
            }

            System.out.println(Thread.currentThread().getName() + " - Priority: " + Thread.currentThread().getPriority() + " - Count: " + i);

            try {
                Thread.sleep(100);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        DuckThread l = new DuckThread("Low");
        DuckThread m = new DuckThread("Medium");
        DuckThread h = new DuckThread("High");
        l.setPriority(Thread.MIN_PRIORITY);
        m.setPriority(Thread.NORM_PRIORITY);
        h.setPriority(Thread.MAX_PRIORITY);

        l.start();
        m.start();
        h.start();
    }
}
