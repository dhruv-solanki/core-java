package Collections.QueueInterfaceExamples;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// It is double ended queue, allow insert, remove, and get from both ends
// It is better than Stack and Queue and allows operations of both
// It uses circular array, using head and tail
// No need to shift elements
// Just shift head and tail
// That's why it is much faster
public class DequeExample {
    public static void main(String[] args) {
//        faster iteration
//        low memory usage than LinkedList due to no Node storage
//        no null allowed
        Deque<Integer> deque = new ArrayDeque<>();
//        we can also use LinkedList as Deque
//        it is faster for insertion and deletion
//        Deque<Integer> deque1 = new LinkedList<>();

        deque.addFirst(10); // add at front
        deque.addLast(20); // add at last
        deque.offerFirst(5); // add at first
        deque.offerLast(25); // add at last

        System.out.println(deque);

        System.out.println("First Element: " + deque.getFirst());
        System.out.println("Last Element: " + deque.getLast());

        deque.removeFirst(); // removes first: 5
        deque.pollLast(); // removes last: 25

        System.out.println(deque);
    }
}
