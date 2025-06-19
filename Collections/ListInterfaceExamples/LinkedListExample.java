package Collections.ListInterfaceExamples;

// It is collection of objects that is called Node
// And each Node contains two things value and pointer(reference) to the next Node
// In Java LinkedList class it is implemented with Doubly Linked List
// Means each Node will contain 3 things
// Value, prev reference - pointing to prev Node, next reference - pointing to next Node
// Time Complexity:
// get: O(n) - Because we need to traverse until we reach specified index
// add: O(1) - As we already have pointers we don't need to do shifting
// remove: O(1) -  Same for removal no need to do shifting
// Use case: efficient insertion and removal

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.addLast(4);
        list.addFirst(0);
        System.out.println(list);

//        we are giving it a predicate that is just function returning boolean value
//        it will remove all the odd numbers from list
        list.removeIf(x -> x % 2 == 1);
        System.out.println(list);

        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat", "Dog", "Elephant"));
        List<String> animalsToRemove = Arrays.asList("Dog", "Lion");
//        removes other collection items from animals collection
        animals.removeAll(animalsToRemove);
        System.out.println(animals);
    }
}
