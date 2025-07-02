package Inheritance.Animal;

public interface Species {
    int MAX_AGE = 150;

    void makeSound();

    static void info() {
        System.out.println("This is Species Interface");
    }

//    default method: used for backward compatibility
//    let's say this interface is implemented by 10 classes
//    and if I have to add one method to this interface then
//    all 10 classes have to write their own implementation
//    so to save that we can create default method
//    that can be directly called by objects.
    default void breath() {
        System.out.println(this.getClass() + " is breathing");
    }
}
