package Collections.ListInterfaceExamples;

import java.util.ArrayList;
import java.util.List;

class Animal implements Comparable<Animal> {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Animal animal) {
        return this.age - animal.age;
    }

    @Override
    public String toString() {
        return "{Name: " + name + ", Age: " + age + "}";
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        List<Animal> list = new ArrayList<>();
        list.add(new Animal("Tom", 9));
        list.add(new Animal("Jerry", 3));
        list.add(new Animal("Bob", 7));
        list.add(new Animal("Cheesy", 5));
        System.out.println(list);

//        if we run this method then JVM will throw an exception
//        because we have given custom class into list
//        so it needs to implement Comparable interface

//        when we implement compareTo method in class
//        list.sort(null) will use that by default sorting technique
        list.sort(null);
        System.out.println(list);
    }
}
