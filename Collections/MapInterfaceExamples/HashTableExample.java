package Collections.MapInterfaceExamples;

import java.util.Hashtable;

// It implements Map interface
// It is synchronised means Thread safe
// No Null key or value is allowed
// Legacy class no one uses, replaced by ConcurrentHashMap
// Slower than HashMap because of overhead due to synchronised
// It uses only LinkedList in case of collision (where HashMap uses RB Tree after threshold)

// Limitation:
// Even read operation is synchronised due to that Reader thread will be also blocked
// when other threads are in progress.
public class HashTableExample {
    public static void main(String[] args) {
        Hashtable<Integer, String> table = new Hashtable<>();
        table.put(1, "Tom");
        table.put(2, "Jerry");
        table.put(3, "Bob");
        System.out.println(table);

//        both will throw an error
        table.put(null, "Cheesy");
        table.put(4, null);
    }
}
