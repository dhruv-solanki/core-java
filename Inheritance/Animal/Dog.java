package Inheritance.Animal;

public class Dog extends Animal {
    public Dog(String name) {
        this.name = name;
        System.out.println("Dog constructor called!");
    }

    public void makeSound() {
        System.out.println("Woof!");
    }

    public String getName() {
        return "Inheritance.Animal: " + this.name;
    }
}
