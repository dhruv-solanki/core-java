package Collections.MapInterfaceExamples;
import java.util.concurrent.ConcurrentSkipListMap;

// It is basically sorted thread safe map
// It uses Skip List: probabilistic data structure to store data instead of RB tree like TreeMap
// Skip List contains layers where 1st layer has all the elements
// 2nd layer has 1 element then next element skipped, just like that continue
// now element will be searched from last layer to bottom till layer 1

// Same as ConcurrentHashMap just elements are sorted
public class ConcurrentSkipListMapExample {
    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>();
        map.put(111, "Java");
        map.put(333, "Python");
        map.put(222, "JavaScript");
        System.out.println(map);
    }
}
