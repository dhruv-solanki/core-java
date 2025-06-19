package Collections.MapInterfaceExamples;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapExample {
    public static void main(String[] args) {
        String key1 = new String("key");
        String key2 = new String("key");

//        with HashMap it uses hashcode method of class
//        and String class has its own hashcode method
//        that uses content of the string to calculate the hashcode
//        so for both key1 and key2 hashcode will be same
//        and even if hashcode is different then it will use
//        equals method to check if values are same of key,
//        and it is same here so it will replace

//        we use hashcode and equals in case of HashMap
//        Map<String, Integer> map = new HashMap<>();
//        both hashcode will be same
        System.out.println(key1.hashCode());
        System.out.println(key2.hashCode());

//        but when we use IdentityHashMap it uses Object's hashcode
//        method to find the hashcode, and here both key1 and key2 are different objects
//        so hashcode will be different, and it will store both into map
//        and even if hashcode is same then it will use == operator
//        instead of equals method so == checks for reference are same or not

//        we use identity hashcode and == in case of IdentityHashMap
        Map<String, Integer> map = new IdentityHashMap<>();
//        both hashcode will be different
        System.out.println(System.identityHashCode(key1));
        System.out.println(System.identityHashCode(key2));

        map.put(key1, 1);
        map.put(key2, 2);
        System.out.println(map);
    }
}
