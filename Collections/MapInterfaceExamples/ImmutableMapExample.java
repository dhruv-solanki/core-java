package Collections.MapInterfaceExamples;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        map1.put("C", 3);
//        one way to create immutable map, can't be changed
        Map<String, Integer> map2 = Collections.unmodifiableMap(map1);
        System.out.println(map2);
//        map2.put("D", 4); // throws exception

//        second way to create immutable map, but can only give 10 entries maximum
        Map<String, Integer> map3 = Map.of("E", 5, "F", 6, "G", 7);
        System.out.println(map3);

//        third way to create immutable map, can give more than 10 entries as well
        Map<String, Integer> map4 = Map.ofEntries(Map.entry("X", 24), Map.entry("Y", 25), Map.entry("Z", 26));
        System.out.println(map4);
    }
}
