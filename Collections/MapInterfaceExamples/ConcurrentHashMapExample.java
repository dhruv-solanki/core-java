package Collections.MapInterfaceExamples;

// Java 7: It uses segment based locking

// After Java 8:
// It uses Compare and Swap approach
// No locking except resizing and collision

import java.util.concurrent.ConcurrentHashMap;

// Example:
// Thread A : work is to change value of x to 50
// it last saw value of x = 40
// so it will check if the value of x == 40 then change to 50
// otherwise don't change and retry
// if more retry occurs then sleep for some random time
// to avoid the CPU overhead.

// Here read operation are lock free
// means anyone can read from map even if someone is writing or reading
// but write operation are locked
// means two thread simultaneously can't write
public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        Thread reader = new Thread(() -> {
            for(int i=0; i<10; i++) {
                System.out.println(map.get(i));
            }
        });
        Thread writer = new Thread(() -> {
            for(int i=0; i<10; i++) {
                map.put(String.valueOf(i),  i * 2);
            }
        });

        writer.start();
        reader.start();

        try {
            writer.join();
            reader.join();
        } catch(InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(map);
    }
}
