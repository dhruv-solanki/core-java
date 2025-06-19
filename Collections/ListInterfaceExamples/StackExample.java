package Collections.ListInterfaceExamples;

import java.util.LinkedList;
import java.util.Stack;

// It extends Vector class, so it is also Thread safe
// It has LIFO structure: Last In First Out
// The element you added last will be removed first
public class StackExample {
    public static void runLinkedListAsStack() {
//        we can also use LinkedList class to implement Stack features
        LinkedList<Integer> slist = new LinkedList<>();
//        it is push operation
        slist.addLast(1);
        slist.addLast(2);
        slist.addLast(3);
        slist.addLast(4);
        System.out.println(slist);

//        it is pop operation
        Integer last = slist.removeLast();
        System.out.println(last);
        System.out.println(slist);

//        it is peek operation
        Integer lastPeek = slist.getLast();
        System.out.println(lastPeek);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);

//        removes the last element: 5
        Integer popped = stack.pop();
        System.out.println(popped);
        System.out.println(stack);

//        just seeing the last element: 4, it does not remove
        Integer peeked = stack.peek();
        System.out.println(peeked);

        runLinkedListAsStack();
    }
}
