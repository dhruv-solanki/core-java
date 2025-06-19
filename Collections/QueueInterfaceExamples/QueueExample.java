package Collections.QueueInterfaceExamples;

import java.util.LinkedList;
import java.util.Queue;

// It has FIFO structure: First In First Out
// The element you added first will be removed first
// So elements are inserted into end (enqueue) and removed from front (dequeue)

// enqueue:
// 1. add - throws exception if reached limit
// 2. offer

// dequeue:
// 1. remove - throws exception if empty
// 2. poll

// peek:
// 1. peek
// 2. element - throws exception if empty

public class QueueExample {
    public static void runLinkedListAsQueue() {
        LinkedList<Integer> list = new LinkedList<>();
//        add element at last
//        enqueue
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        System.out.println(list);
//        remove from first
//        dequeue
        Integer i = list.removeFirst();
        System.out.println(list);
//        peek
        System.out.println(list.getFirst());
    }

    public static void main(String[] args) {
//        LinkedList implements Dequeue that extends Queue
        Queue<Integer> queue = new LinkedList<>();
//        enqueue
        queue.add(9);
        queue.add(8);
        queue.add(7);
        System.out.println(queue);

//        dequeue
        Integer removed = queue.remove();
        System.out.println(queue);

//        peek
        System.out.println(queue.peek());
//        runLinkedListAsQueue();
    }
}
