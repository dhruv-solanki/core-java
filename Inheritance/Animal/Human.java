package Inheritance.Animal;

public abstract class Human {
    public static int MAX_AGE = 150;

    public Human() {
        System.out.println("Human constructor");
    }

    public abstract void walk();

    public abstract void sleep();

    public void breath() {
        System.out.println("Human is breathing...");
    }


}
