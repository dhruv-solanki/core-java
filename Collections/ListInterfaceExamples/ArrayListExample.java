package Collections.ListInterfaceExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// ArrayList is an array of dynamic size
// default capacity is 10 that will be increased with rate of 1.5x

// Time Complexity:
// get: O(1)
// add: O(n) - if add into middle or first then element have to be shifted
// remove: O(n) - same for removal, elements have to be shifted
// Use case: efficient access
public class ArrayListExample {
    public static void runIntegerArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(4);

        list.add(1, 7);

//        it will remove by index means element 4
        list.remove(5);
//        it will remove by element means 1
        list.remove(Integer.valueOf(1));
//        update element at index 0 with new element 9
        list.set(0, 9);

        Integer el = list.get(3);
        System.out.println(el);

        System.out.println(list);
    }

    public static void runStrArrayList() {
        List<String> strList = new ArrayList<>(5);

        String[] fruits = {"Apple", "Banana", "Kiwi", "Cherry", "Watermelon"};
        List<String> fruitList = Arrays.asList(fruits);
        strList.addAll(fruitList);

        for(String fruit: strList) {
            System.out.println(fruit);
        }
    }

    public static void main(String[] args) {
        runIntegerArrayList();

        runStrArrayList();
    }
}
