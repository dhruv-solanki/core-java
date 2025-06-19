package Collections.ListInterfaceExamples;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// "Copy on Write" means that whenever a write operation occurs
// like adding or removing an element
// instead of directly modifying the existing list
// a new copy of the list is created
// and the modification is then applied to that new copy
// this ensures that other threads reading the list
// will be unaffected by the modification

// Read: fast and direct, this happens on main list
// Write: a new copy of list is created each write operation
// Then reference to the list is updated for subsequent reads to use the new list
public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        List<String> shoppingList = new CopyOnWriteArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Bread");
        shoppingList.add("Vegetables");
        System.out.println("Initial shopping list: " + shoppingList);

        for(String item: shoppingList) {
            System.out.println(item);
//            try to modify the list while reading
//            this is throwing exception with ArrayList class
//            ConcurrentModificationException
//            because it requires a stable list while reading (loop) - snapshot, but we just changed.
//            so we can use CopyOnWriteArrayList
//            so that read will happen on stable snapshot of list
//            while for writing it will create new copy (snapshot), and then update it.
            if(item.equals("Bread")) {
                shoppingList.add("Butter");
                System.out.println("Added Butter while reading.");
            }
        }
//        this is new snapshot, updated with Butter in it
        System.out.println("Updated shopping list: " + shoppingList);
    }
}
