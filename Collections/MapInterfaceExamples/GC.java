package Collections.MapInterfaceExamples;

import java.lang.ref.WeakReference;

class Phone {
    private String brand;
    private String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone{brand: " + brand + ", model: " + model + "}";
    }
}

public class GC {
    public static void main(String[] args) {
//        here nokia is called strong reference, all references are strong reference
//        that means they will no be removed by GC (Garbage Collector) until we assign null to them
        Phone nokia = new Phone("Nokia", "1210");
        System.out.println(nokia);
//        now we have assigned null to reference so there is no way to reach object in heap
//        here now GC can free the memory from heap because objects are stored in there
        nokia = null;
        System.out.println(nokia);

//        here we are using weak reference, means GC can free up the memory for the reference
//        GC has its own Algorithms to determine when to free the memory

//        USE CASE: we can use this for caching purpose
//        where even if cache doesn't have the data we can fetch from original source
//        so if some time have passed then GC can automatically pick up
//        Weak References for freeing up the memory
        WeakReference<Phone> weakRef = new WeakReference<>(new Phone("Apple", "iPhone 14"));
        System.out.println(weakRef.get());
//        here we are suggesting GC that you can now free up the memory
        System.gc();
//        waiting for 5 seconds
        try {
            System.out.println("Wait for 5 sec...");
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            System.out.println(e);
        }
//        now GC will have removed the object from heap memory
//        and it will print the null
        System.out.println(weakRef.get());
    }
}
