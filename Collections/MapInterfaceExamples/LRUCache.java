package Collections.MapInterfaceExamples;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
//        Here we are creating LRU Cache of capacity 5
//        means whenever we add 6th entry, the LRU/the eldest entry will be removed
        LRUCache<String, Integer> cache = new LRUCache<>(5);
        cache.put("Alice", 90);
        cache.put("Bob", 80);
        cache.put("James", 77);
        cache.put("Lily", 88);
        cache.put("Suzan", 65);
        System.out.println("Before adding 6th Entry: " + cache);

//        The LRU (Least Recently Used) entry will be removed
//        either you use get or put method it is accessed
//        so the removeEldestEntry method will run to remove eldest entry
        cache.put("Cameron", 93);
        System.out.println("After adding 6th Entry: " + cache);
    }
}
