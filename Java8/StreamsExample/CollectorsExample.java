package Java8.StreamsExample;

import java.util.*;
import java.util.stream.Collectors;

// It is terminal operation in streams
// It is also utility class that provide lots of useful methods
public class CollectorsExample {
    public static void runMethodExamples() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Cameron");

//        1. collect as a list
        List<String> collect1 = names.stream().collect(Collectors.toList());
        System.out.println("List: " + collect1);

        List<Integer> nums = Arrays.asList(1, 2, 2, 3, 3, 4, 4, 5);

//        2. collect as a set
        Set<Integer> collect2 = nums.stream().collect(Collectors.toSet());
        System.out.println("Set: " + collect2);

//        3. collecting to specific collection
        ArrayDeque<String> deque = names.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));
        System.out.println("Specific Collection Deque: " + deque);

//        4. joining strings
        String commaStrs = names.stream().collect(Collectors.joining(", "));
        System.out.println("Collectors joining: " + commaStrs);

//        5. summarizing data
//        Generates statistical summary (min, max, avg, count, sum)
        IntSummaryStatistics summary = nums.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Min: " + summary.getMin());
        System.out.println("Max: " + summary.getMax());
        System.out.println("Avg: " + summary.getAverage());
        System.out.println("Count: " + summary.getCount());
        System.out.println("Sum: " + summary.getSum());

//        6. avg direct
        Double avg = nums.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println("Direct Avg: " + avg);

//        7. counting elements
        Long count = nums.stream().collect(Collectors.counting());
        System.out.println("Direct Count: " + count);

//        8. grouping elements
        List<String> words = Arrays.asList("hello", "world", "java", "streams", "collectors");
        Map<Integer, List<String>> groupStr1 = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("Group by str length: " + groupStr1);

        Map<Integer, String> groupStr2 = words
                .stream()
                .collect(
                        Collectors.groupingBy(
                                String::length,
                                Collectors.joining("-")
                        )
                );
        System.out.println("Group by str length and join with dash: " + groupStr2);

        TreeMap<Integer, Long> groupStr3 = words
                .stream()
                .collect(
                        Collectors.groupingBy(
                                String::length,
                                TreeMap::new,
                                Collectors.counting()
                        )
                );
        System.out.println("Group by str length and count and create new data structure: " + groupStr3);

//        9. partitioning elements
//        it creates two partitions (groups) true and false based on predicate
        Map<Boolean, List<String>> groups = words
                .stream()
                .collect(
                        Collectors.partitioningBy(s -> s.length() > 5)
                );
        System.out.println(groups);

//        10. mapping and collecting
//        applies mapping function before collecting
        List<String> mappedList = words.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList()));
        System.out.println(mappedList);
    }

    public static void runExamples() {
//        1. collecting names by length
        List<String> l1 = Arrays.asList("Sabrina", "Cillian", "Arthur", "Kevin", "Ben");
        System.out.println(l1.stream().collect(Collectors.groupingBy(String::length)));

//        2. counting word occurrences
        String sentence = "hello world hello java world";
        Map<String, Long> res2 = Arrays
                .stream(sentence.split(" "))
                .collect(
                        Collectors.groupingBy(
                                s -> s,
                                Collectors.counting()
                        )
                );
        System.out.println(res2);

//        3. partitioning even and odd numbers
        List<Integer> l2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(l2.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0)));

//        4. summing values in a Map
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple", 4);
        items.put("Banana", 12);
        items.put("Orange", 10);

        Integer sumOfValues = items.values().stream().reduce(Integer::sum).get();
        Integer sumCollect = items.values().stream().collect(Collectors.summingInt(x -> x));
        System.out.println("Map: sum of values: " + sumCollect);

//        5. creating map from stream of elements
        Map<String, Integer> nameMap = l1.stream().collect(Collectors.toMap(String::toUpperCase, String::length));
        System.out.println(nameMap);

//        6. creating map from duplicate elements / or counting how many times it occurred
        List<String> fruits = Arrays.asList("apple", "cherry", "oranges", "peach", "apple", "oranges", "cherry",
                "apple", "oranges");
//        here k = key, v = value initially 1,
//        and 3rd param is binary operator that takes last v value and sum up with current v = 1
        Map<String, Integer> fruitCount = fruits
                .stream()
                .collect(
                        Collectors.toMap(
                                k -> k,
                                v -> 1,
                                Integer::sum
                        )
                );
        System.out.println(fruitCount);
    }

    public static void main(String[] args) {
        runMethodExamples();

        runExamples();
    }
}
