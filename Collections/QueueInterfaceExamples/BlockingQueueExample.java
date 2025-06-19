package Collections.QueueInterfaceExamples;

import java.util.concurrent.*;

// It is thread safe queue
// It simplify concurrency problem like, producer-consumer

// Standard Queue --> operation happens immediately
// empty: remove (no waiting)
// full: add (no waiting)

// Blocking Queue: Uses Locking
// put: blocks if queue is full until space becomes available
// take: block if queue is empty until an element becomes available
// offer: Waits for space to become available up to specified timeout

// It is an interface: BlockingQueue
// ArrayBlockingQueue: is an implementation class
// A bounded blocking queue backed by a circular array
// Low memory overhead
// Uses a single lock for both enqueue and dequeue operations
// If there are more threads then create a problem

// LinkedBlockingQueue
// An optionally bounded queue backed by a LinkedList
// More memory overhead
// Uses two separate locks for enqueue and dequeue operations
// For more threads no problem

// PriorityBlockingQueue:
// An optionally bounded queue
// Uses binary heap as array and can grow dynamically
// It orders elements based on natural ordering or by provided Comparator
// It does not block put operation

// SynchronousQueue:
// It is consist of only single element
// Every put operation will be followed by take operation
// So at most one element will be inside the Queue
public class BlockingQueueExample {
    public static void runSynchronousQueueExample() {
        BlockingQueue<String> queue = new SynchronousQueue<>();
        Thread producer = new Thread(() -> {
           try {
               System.out.println("Producer is waiting for transfer...");
               queue.put("Hello, from producer!");
               System.out.println("Producer has transferred the message.");
           } catch(InterruptedException e) {
               System.out.println(e);
           }
        });
        Thread consumer = new Thread(() -> {
            try {
                System.out.println("Consumer is waiting to receive...");
                String message = queue.take();
                System.out.println("Message: " + message);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        });

        consumer.start();
        producer.start();
    }

    public static void runBlockingQueueExamples() {
//        BlockingQueue<Integer> queue1 = new LinkedBlockingQueue<>();
//        BlockingQueue<Integer> queue2 = new PriorityBlockingQueue<>();

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch(InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(queue);
    }

    public static void main(String[] args) {
        runBlockingQueueExamples();
    }
}

class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;
    private int value = 0;

    Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            try {
                System.out.println("Producer produced: " + value);
                queue.put(value++);
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            try {
                System.out.println(queue);
                Integer value = queue.take();
                System.out.println("Consumer consumed: " + value);
                Thread.sleep(2000);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
