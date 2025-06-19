package Threads.Synchronized;

class SharedResource {
    private int data;

    private boolean hasData;

    public synchronized void produce(int value) {
//        if data is there then no need to produce just wait
        if(hasData) {
            try {
                wait();
            } catch(InterruptedException e) {
                System.out.println(e);
                Thread.currentThread().interrupt();
            }
        }
//        otherwise produce the data and set hasData = true, because it produced
//        notify other thread that it can now consume the data
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);
        notify();
    }

    public synchronized int consume() {
//        if there is no data then consumer have to wait
        if(!hasData) {
            try {
                wait();
            } catch(InterruptedException e) {
                System.out.println(e);
                Thread.currentThread().interrupt();
            }
        }
//        otherwise consumer the data and set hasData = false, because it consumed
//        and notify other thread that it can now produce more data
        hasData = false;
        System.out.println("Consumed: " + data);
        notify();
        return data;
    }
}

class Producer implements Runnable {
    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            resource.produce(i+1);
        }
    }
}

class Consumer implements Runnable {
    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            resource.consume();
        }
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new Consumer(resource));

        producerThread.start();
        consumerThread.start();
    }
}
