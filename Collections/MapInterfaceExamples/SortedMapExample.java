package Collections.MapInterfaceExamples;

import java.util.SortedMap;
import java.util.TreeMap;

// SortedMap is an interface that extends Map
// it sorts the entries based on key
// in their natural order or by specified comparator

// NavigableMap is an interface that extends SortedMap
// we can use this for doing the closest operations
// so just need to hold it as reference but object will be TreeMap

// Time Complexity:
// get: O(log n)
// put: O(log n)
// remove: o(log n)
public class SortedMapExample {
    public static void main(String[] args) {
//        TreeMap is implementation class
//        it uses internally Self Balanced Binary Search Tree (RB Tree)
//        Key class should have implemented Comparable
//        Or we need to pass the Comparator in the constructor
        SortedMap<Integer, String> map = new TreeMap<>((a, b) -> b - a);
        map.put(9, "Ironman");
        map.put(1, "Batman");
        map.put(3, "Spider Man");
        map.put(5, "Wonder Woman");
//        it will give Null Pointer Exception
//        because can't sort by null
        map.put(null, "No Hero");
        System.out.println(map);

        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println(map.headMap(5)); // 5 excluded
        System.out.println(map.tailMap(5));
    }
}
