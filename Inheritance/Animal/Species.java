package Inheritance.Animal;

public interface Species {
    int MAX_AGE = 150;

    void makeSound();

    static void info() {
        System.out.println("This is Species Interface");
    }

    default void breath() {
        System.out.println(this.getClass() + " is breathing");
    }
}
