package Generics;

import java.util.List;

// Generics in Java is a powerful feature
// that enables type safety and code reusability by
// allowing classes, interfaces, and methods to
// operate on objects of various types,
// while still providing compile-time type checking.

// ? - Wildcard - when we don't know types in advance

// after compilation type will be removed from the code
// so it will not there in byte code
// this is called type eraser

// you can not create generic exception class
// because exception are thrown at runtime
// as we already know that in Generics types are erased at runtime
// so we can't create generic class that extends Exception class
// the workaround is we can create generic constructor.

class MyException extends Exception {
    public <T> MyException(T value) {
        super("Exception related to value: " + value.toString() + " of type: " + value.getClass().getName());
    }
}

public class Main {
    public static <T> void printArray(T[] array) {
        for(T element: array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

//    upper bound: can't go above this class, all the super classes can't be used
//    all the values below this class can be used, all the subclasses can be used
//    kind of ceil
    public static double sum(List<? extends Number> numbers) {
        double sum = 0;
        for(Number n: numbers) {
            sum += n.doubleValue();
        }
        return sum;
    }

//    lower bound: can't go below this class, all the subclasses can't be used
//    all the values above this class can be used, all the super classes
//    kind of floor
    public static void printNums(List<? super Integer> list) {
        for(Object obj: list) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.setValue("Hello");
        String s = box.getValue();
        System.out.println(s);

        Pair<String, Integer> pair = new Pair<>("Age", 21);
        String age = pair.getKey();
        Integer value = pair.getValue();
        System.out.println(age + ": " + value);

        NumberBox<Long> nb = new NumberBox<>();
        nb.setData(123L);
        Long l = nb.getData();
        System.out.println(l);

        GenericConstructor gc1 = new GenericConstructor("World");
        System.out.println(gc1.getData());

        GenericConstructor gc2 = new GenericConstructor(987);
        System.out.println(gc2.getData());

        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"IronMan", "CaptainAmerica", "Thor"};
        printArray(intArray);
        printArray(strArray);

        double add = Operation.ADD.apply(100, 3);
        double subtract = Operation.SUBTRACT.apply(100, 3);
        double multiply = Operation.MULTIPLY.apply(100, 3);
        double divide = Operation.DIVIDE.apply(100, 3);
        System.out.println("ADD: " + add);
        System.out.println("Subtract: " + subtract);
        System.out.println("Multiply: " + multiply);
        System.out.println("Divide: " + divide);

        try {
            throw new MyException(1200);
        } catch(MyException e) {
            System.out.println(e.getMessage());
        }

        try {
            throw new MyException("Testing...");
        } catch(MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
