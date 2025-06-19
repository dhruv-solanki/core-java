package Collections.MapInterfaceExamples;


import java.util.LinkedHashMap;
import java.util.Map;

// LinkedHashMap extends HashMap
// it actually maintains the order in which items were added
// so it has to add extra Doubly LinkedList data structure
// that can create memory and time overhead,
// but it also has accessOrder parameter
// that is by default false - means insertion order
// and true for access order
// insertion order means list will be maintained in order of insertion
// access order means list will be maintained in order of access
// so whatever item accessed last be shifted at last from its position
// that is called recently accessed element
// so the Least Recently Used elements will be at top (LRU)
// we can use this to built LRU (Least Recently Used) cache
public class LinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(5, 0.5f, true);
        map.put("Apple", 8);
        map.put("Oranges", 10);
        map.put("Banana", 12);

//        if access Order is True then Oranges will be shifted at last in list
        map.get("Oranges");

        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}
