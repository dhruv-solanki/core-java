package Collections.MapInterfaceExamples;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// NOTE:
// Map interface does not extend Collection Interface
// This is separate interface on its own

// HashMap: Unordered collection of objects, that has key and value
// Key should be unique but value can be duplicates

// Time Complexity: without collision
// get: O(1)
// put: O(1)
// remove: O(1)
// But if collision occurs then,
// LinkedList: O(n)
// Binary Search Tree: O(log n)

// contains(key): O(1) / O(log n)
// contains(value): O(n)

// Internals of HashMap:
// It contains 4 things,
// 1: Key - The identifier used to retrieve the value
// 2: Value - The data associated with the key
// 3: Bucket - A place where key-value pair are stored, it is kind of array
// 4: Hash Function - Converts a key into an index for storage(bucket location)

// Hash Function - It is an algorithm that takes input (or key)
// and returns fixed size of string bytes, typically numerical value.
// The output is known as Hash code, Hash value, or simply hash.
// The primary purpose of Hash function is to
// map data of arbitrary size to data of fixed size.

// int index = hashcode % arraySize
// All this Bucket (Array) contains LinkedList for collision detection
// As hash function will produce fixed size of data
// so for different keys it is possible that hashcode will be same
// so they will be inserted into same index but as LinkedList

// Array[] bucket = {Node(K1, V1), Node(K2, V2)};
// class Node<K, V> {
//    final int hash;
//    final K key;
//    V value;
//    Node<K, V> next;
// }
// Note: After Java 8, instead of LinkedList that takes O(n) time for searching,
// Now Java uses Balanced Binary Search Tree (RB(Red Black) Tree)
// that takes O(log n) time for searching
// if elements exceeds certain threshold limit that is currently: 8
// Java will convert LinkedList into RB Tree

// HashMap Resizing: It is called Rehashing
// The internal array's default capacity is 16.
// But if elements increase above certain load factor (0.75)
// HashMap internal array will resize to hold more data
// that is called rehashing.
// At the time of rehashing capacity will be doubled (2x).
// All the entries are rehashed (their position will be recalculated)
// and placed into new array.

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Batman");
        map.put(2, "Wonder Woman");
        map.put(3, "Superman");
        map.put(4, "Flash");

        String h1 = map.get(2);
        System.out.println(h1);
//        key does not exist so null
        String h2 = map.get(5);
        System.out.println(h2);

        System.out.println(map.containsKey(3));
        System.out.println(map.containsValue("Arrow"));

//        keySet: returns set of keys from map
        for(int i: map.keySet()) {
            System.out.println(map.get(i));
        }

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for(Map.Entry<Integer, String> entry: entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            entry.setValue(entry.getValue().toUpperCase());
        }
        System.out.println(map);

        String h3 = map.remove(3);
        System.out.println("Last removed Hero: " + h3);
//        returns boolean if removed or not
        boolean removed = map.remove(4, "Arrow");
        System.out.println("Arrow Removed? " + removed);

        System.out.println(map);

//        get value if exist else default value provided as second argument
        String h4 = map.getOrDefault(1, "Superman");
        System.out.println("Value of 1: " + h4);
        String h5 = map.getOrDefault(7, "Arrow");
        System.out.println("Value of 7 or default: " + h5);

//        put key, value only if absent
        map.putIfAbsent(4, "Joker");
        map.putIfAbsent(5, "Cat Woman");
        System.out.println(map);
    }
}
