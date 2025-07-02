package Enums;

// enum (short for enumeration) is a special data type
// that enables a variable to be a set of predefined constant values.
// An enum is a type-safe way to represent a fixed set of constants

// In Java, every enum is implicitly a final class that extends java.lang.Enum.
// You can:
// Add fields
// Define constructors
// Add methods
// Override methods

// values()	            Returns an array of all enum constants
// valueOf(String name)	Returns enum constant by name
// ordinal()	        Returns position (starting at 0)
// name()	            Returns name of constant as String

// Enums and Singleton Pattern
// Enums are the best way to implement Singletons in Java:

enum Singleton {
    INSTANCE;

    public void doSomething() {
        System.out.println("Doing work...");
    }
}

public class Main {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        instance.doSomething();

        System.out.println(Days.MONDAY);
        for(Days day: Days.values()) {
            System.out.println(day.ordinal() + 1 + " : " + day.name());
        }

        Days.FRIDAY.display();

        Days newDay = Days.SUNDAY;

        switch(newDay) {
            case Days.MONDAY: {
                System.out.println("Time to start your work");
                break;
            }
            case Days.SATURDAY: {
                System.out.println("Weekend started, let's plan!");
                break;
            }
            case Days.SUNDAY: {
                System.out.println("Time to chill and relax!");
                break;
            }
        }
    }
}
