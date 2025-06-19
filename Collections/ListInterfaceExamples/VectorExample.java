package Collections.ListInterfaceExamples;

import java.util.Vector;

// It is legacy synchronised collection class that implements List interface
// It behave same as ArrayList and grow as needed, but it grows as a rate of 2x
// It provides Thread safety because all methods in it are synchronised
// But comes with a performance overhead in single thread environment
// So only use in Multi-Threaded environment, otherwise use ArrayList
// Use case: efficient access with Thread safety
public class VectorExample {
    public static void runSimpleExample() {
//        we can give initial capacity and how much to increment when needed
        Vector<Integer> vlist = new Vector<>(5, 3);
        vlist.add(1);
        vlist.add(2);
        vlist.add(3);
        vlist.add(4);
        vlist.add(5);
//        capacity is 5
        System.out.println(vlist.capacity());
//        but now it will be 8 = 5 + 3
        vlist.add(6);
        System.out.println(vlist.capacity());
        System.out.println(vlist);
    }

    public static void main(String[] args) {
//        so here if we use ArrayList then size at the end will be changing
//        it will not be fixed 20000 every time
//        because ArrayList is not thread safe
//        but if we use Vector here then every time we run the size will be 20000
//        because Vector class is thread safe by default, synchronised
//        ArrayList<Integer> list = new ArrayList<>();
        Vector<Integer> list = new Vector<>();
        Thread t1 = new Thread(() -> {
            for(int i=0; i<10000; i++) {
                list.add(i);
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i=0; i<10000; i++) {
                list.add(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch(InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("List size: " + list.size());
    }
}
