package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

// Java8: Reasons
// Write minimal code
// Support functional programming
// We can use interface reference to hold an anonymous function / lambda function
// This is called functional programming in Java
// Basically we can hold a method in a variable

// It introduced:
// Lambda Expression
// Streams
// Date and Time API
// Base64 encode and decode
// Method Reference and Constructor Reference
// Default and Static methods in interface
// Functional Interface
// Optional Class and IO and Collection API improvements

public class Java8Example {
    public static void runPredicateExample() {
        System.out.println("Predicate Example:");
//        Predicate is Boolean values function: Functional Interface
//        that just return boolean value
//        you can write any logic inside this
//        to test out on single variable
        Predicate<Integer> isEven = (x) -> x % 2 == 0;
        System.out.println(isEven.test(20));
        System.out.println(isEven.test(5));

        Predicate<String> isStartsWithA = x -> x.toLowerCase().startsWith("a");
        Predicate<String> isEndsWithZ = x -> x.toLowerCase().endsWith("z");
        Predicate<String> checkAandZ = isStartsWithA.and(isEndsWithZ);
        System.out.println(checkAandZ.test("ABDZ"));
    }

//    Function: functional interface
//    Accept argument and performs some actions and returns the result
    public static void runFunctionExample() {
        System.out.println("Function Example:");
        Function<Integer, Integer> doubleIt = x -> x * 2;
        Function<Integer, Integer> tripleIt = x -> x * 3;
        System.out.println(doubleIt.apply(10));
        System.out.println(tripleIt.apply(20));
        System.out.println(doubleIt.andThen(tripleIt).apply(30));
    }

//    Consumer: functional interface
//    It only accepts arguments and perform actions
//    But doesn't return the result
//    So only consumes
    public static void runConsumerExample() {
        System.out.println("Consumer Example:");
        Consumer<Integer> print = (x) -> System.out.println(x);
        print.accept(10);

        List<Integer> list = Arrays.asList(11, 22, 33, 44);
        Consumer<List<Integer>> printList = (x) -> {
          for(int i: x) {
              System.out.print(i + " ");
          }
        };
        printList.accept(list);
        System.out.println();
    }

//    Supplier: functional interface
//    It doesn't accept arguments
//    But perform some actions and return the result
//    So only supply
    public static void runSupplierExample() {
        System.out.println("Supplier Example:");
        Supplier<String> giveHello = () -> "Hello";
        System.out.println(giveHello.get());
    }

//    BiPredicate, BiFunction, BiConsumer
    public static void runBIExample() {
        System.out.println("Bi Examples:");
//        two input types
        BiPredicate<Integer, Integer> isSumEven = (x, y) -> (x + y) % 2 == 0;
        System.out.println(isSumEven.test(10, 20));

//        two input types
        BiConsumer<Integer, String> biConsumer = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        };
        biConsumer.accept(10, "Hello");

//        two input types and one return type
        BiFunction<String, String, Integer> biFunc = (x, y) -> (x + y).length();
        System.out.println(biFunc.apply("Tony", "Steve"));

//        UnaryOperator and BinaryOperator
//        Function of same input and return type
        UnaryOperator<Integer> a = x -> x * 2;
//        Function of BiFunction type where two input and one return type is same
        BinaryOperator<Integer> b = (x, y) -> x * y;

        System.out.println(a.apply(22));
        System.out.println(b.apply(22, 33));
    }

    public static void main(String[] args) {
        Operation opSum = (a, b) -> a + b;
        Operation opSub = (a, b) -> a - b;
        Operation opMul = (a, b) -> a * b;
        Operation opDiv = (a, b) -> a / b;

        System.out.println(opSum.operate(10, 20));
        System.out.println(opSub.operate(10, 20));
        System.out.println(opMul.operate(10, 20));
        System.out.println(opDiv.operate(10, 20));

        runPredicateExample();

        runFunctionExample();

        runConsumerExample();

        runSupplierExample();

        runBIExample();

        System.out.println("Method Reference Example:");
        List<String> birds = Arrays.asList("Crow", "Parrot", "Sparrow");
//        birds.forEach((b) -> System.out.println(b));
        birds.forEach(System.out::println);
    }
}

// Functional Interface
// An interface that has only one abstract method
// It can have multiple default and static methods
interface Operation {
    int operate(int a, int b);
}
