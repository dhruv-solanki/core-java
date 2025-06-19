package Collections.QueueInterfaceExamples;

import java.util.Comparator;
import java.util.PriorityQueue;

// it implements Queue interface just like LinkedList
// it orders elements based on their natural ordering
// so top elements have the highest priority, that we can remove to process
// does not allow null elements
// we can give Comparator for custom ordering

// if we print pq then elements will not be sorted
// it only happens when we remove the first element

// Internal Working:
// PQ is implemented with min-heap.
// Min-heap: Binary Tree where each node is smaller or equal than its child nodes
// Time Complexity:
// add: O(log n)
// remove: O(log n)
// get: O(1) - because smallest element will be the root of tree, so will be at top

public class PriorityQueueExample {
    public static void main(String[] args) {
//        here in constructor we can give our custom Comparator
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(9);
        pq.add(1);
        pq.add(0);
        pq.add(3);
//        not sorted when we print
        System.out.println(pq);
//        sorted when we remove them or peek
        while(!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}
