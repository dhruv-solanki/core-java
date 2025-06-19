package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

// Iterable is an interface implemented by all collection classes
// It gives collection an ability to iterate
// Basically, we can use for loop on collection

// Also it gives more control
// You can not modify list while iterating over it in for loop
// But you can do that when you are iterating over iterator
public class IterableExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
//        for(int i: list) {
//            System.out.println(i);
//        }

//        it gives iterator that we can iterate over, same as for loop
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            Integer next = iterator.next();
            if(next % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(list);

        ListIterator<Integer> integerListIterator = list.listIterator();
        while(integerListIterator.hasNext()) {
            Integer next = integerListIterator.next();
            boolean flag = false;
            if(next == 5) {
                while(integerListIterator.hasPrevious()) {
                    System.out.println(integerListIterator.previous());
                }
                flag = true;
            }
            if(flag) {
                break;
            }
        }
    }
}
