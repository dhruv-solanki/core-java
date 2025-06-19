package Inheritance.Animal;

public class Animal implements Species {
    public String name;

    public int age;

    public static int count;

    public Animal() {
        count++;
        System.out.println("Inheritance.Animal contructor called!");
    }

    static {
        System.out.println("The first block that will run!");
    }

    @Override
    public void makeSound() {
        System.out.println("...");
    }

    public String getAnimal(Dog dog) {
        return dog.getName();
    }

    public String getAnimal(Cat cat) {
        return cat.getName();
    }
}
