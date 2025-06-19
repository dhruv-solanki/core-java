package Collections.QueueInterfaceExamples;
// ConcurrentLinkedQueue and ConcurrentLinkedDeque
// both uses same concept compare and swap
// just like ConcurrentHashMap

// Here they don't use locks like BlockingQueue
// so we can perform put / add or take simultaneously

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueExample {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> queue1 = new ConcurrentLinkedQueue<>();
        ConcurrentLinkedDeque<Integer> queue2 = new ConcurrentLinkedDeque<>();
    }
}
