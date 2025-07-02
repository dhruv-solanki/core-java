package Inheritance.Animal;

public class Test {
    public static void main(String[] args) {
        Dog bull = new Dog("Bull Dog");
        bull.makeSound();

        Cat tom = new Cat("Tom Cat");
        tom.makeSound();

//        method overloading example: compile time polymorphism
        Animal dog = new Animal();
        System.out.println(dog.getAnimal(bull));

        Animal cat = new Animal();
        System.out.println(cat.getAnimal(tom));

//        method overriding example: run time polymorphism
        Animal goldy = new Dog("Goldy");
        goldy.makeSound();

        Animal winy = new Cat("Winy");
        winy.makeSound();

        System.out.println(Animal.count);

        Species.info();

        goldy.breath();
        winy.breath();

    }
}
