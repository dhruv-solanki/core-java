package Java8.StreamsExample;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

// Intermediate operations transform a stream into another stream
// They are lazy means they don't execute until a terminal operation is invoked
public class IntermediateOperationsExample {
//    this shows that filtering won't happen until we run terminal operation
//    so this is lazy evaluation
    public static void runLazyEvaluationExample() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Tom");

        Stream<String> stringStream = names.stream().filter((name) -> {
            System.out.println("Filtering name: " + name);
            return name.length() > 3;
        });

        System.out.println("Before terminal operation");

        List<String> res = stringStream.toList();

        System.out.println("After terminal operation");
        System.out.println(res);
    }

    public static void main(String[] args) {
//        1. filter
        List<String> list = Arrays.asList("Rose", "Bruno", "Taylor", "Ariana", "Behance");
        Stream<String> stringStream = list.stream().filter(s -> s.length() == 4 || s.length() == 5);
//        no filtering at this point
//        but count is terminal operation so now filtering will happen
        long res = stringStream.count();
        System.out.println("Names length is either 4 or 5: " + res);

//        2. map
        Stream<String> mapStream = list.stream().map(String::toUpperCase);

//        3. sorted
        Stream<String> sortedStream = list.stream().sorted();
        Stream<String> customSortedStream = list.stream().sorted((a, b) -> a.length() - b.length());

//        4. distinct
        Stream<String> distinctStream = list.stream().filter(s -> s.startsWith("B")).distinct();
        System.out.println("Distinct Names starts with B: " + distinctStream.count());

//        5. limit
        Stream<Integer> limitStream = Stream.iterate(1, x -> x + 10).limit(10);
        System.out.println("Limit count: " + limitStream.count());
//        if one terminal operation is executed then
//        we can't process that stream again with another terminal operation
//        System.out.println(limitStream.collect(Collectors.toList()));

//        6. skip
        Stream<Integer> skipLimitStream = Stream.iterate(1, x -> x + 10).skip(20).limit(30);
        System.out.println("Skip limit count: " + skipLimitStream.count());

//        7. peek: performs action on each element as it consumed
        long count = Stream.iterate(0, x -> x + 10).limit(10).peek(System.out::println).count();
        System.out.println("Peek count: " + count);

//        8. flatMap:
//        handles stream of collections, lists, arrays
//        where each element is itself a collection
//        it flattens nested structure
//        it transform and flatten at the same time
        List<List<String>> listOfList = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("pear", "grape")
        );
        List<String> flatenFruitList = listOfList
                .stream()
                .flatMap(Collection::stream)
                .map(String::toUpperCase)
                .toList();
        System.out.println(flatenFruitList);

        List<String> sentences = Arrays.asList(
                "Hello World",
                "Java Streams are powerful",
                "flatMap is very useful"
        );
        List<String> flatenStr = sentences
                .stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .map(String::toUpperCase)
                .toList();
        System.out.println(flatenStr);

        runLazyEvaluationExample();
    }
}
