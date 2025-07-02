package Collections.MapInterfaceExamples;

import java.util.HashMap;
import java.util.Objects;

class Person {
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

//    we are checking on basis of name and id
//    so for two objects if name and id are same
//    then that two objects will generate same hashcode
    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public boolean equals(Object obj) {
//        edge cases
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
//        actual equals logic goes here
        Person other = (Person) obj;
        return id == other.id && Objects.equals(name, other.name);
    }

    @Override
    public String toString() {
        return "(id: " + id + ", name: " + name + ")";
    }
}

public class HashCodeAndEqualsExample {
//    Here for two same string, hashcode will be same so index will be same
//    it will go and check at that index if string are same or not
//    here String class has its implementation of equals method
//    that will check for if two strings are same or not
//    if same then replace it instead of adding new one
    public static void runStringKeyExample() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apple", 6); // hashcode1 -> index1
        map.put("Banana", 12); // hashcode2 -> index2
//        it will replace the (Apple, 6) entry
        map.put("Apple", 8); // hashcode1 -> index1 -> equals -> replace
        System.out.println("Size of Map: " + map.size());
        System.out.println(map);
    }

//    here it failed to identify that p1 and p2 are same object
//    because every class extends Object class
//    and Object class by default uses reference memory address in consideration
//    to generate hashcode, that's why hashcode will be different
//    and instead of replacing the value at the key, it will add new one

//    Note: If we add our own hashcode and equals method then above scenario will not happen
    public static void runClassKeyExample() {
        Person p1 = new Person("James", 123);
        Person p2 = new Person("Lily", 234);
        Person p3 = new Person("James", 123);

        HashMap<Person, String> map = new HashMap<>();
        map.put(p1, "Engineer"); // hashcode1 -> index1
        map.put(p2, "Designer"); // hashcode2 -> index2
//        it will not add new entry instead it will replace it
        map.put(p3, "Manager"); // hashcode3 -> index3
        System.out.println("Size of Map: " + map.size());
        System.out.println(map);
    }

    public static void main(String[] args) {
        runStringKeyExample();

        runClassKeyExample();
    }
}
