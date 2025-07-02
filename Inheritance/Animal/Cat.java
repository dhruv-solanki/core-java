package Inheritance.Animal;

public class Cat extends Animal {
    public Cat(String name) {
        this.name = name;
        System.out.println("Cat constructor called!");
    }

    public void makeSound() {
        System.out.println("Meow!");
    }

    public String getName() {
        return "Inheritance.Animal: " + this.name;
    }
}
