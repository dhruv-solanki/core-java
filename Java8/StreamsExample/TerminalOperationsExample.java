package Java8.StreamsExample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Terminal operations are the end operation that we perform on stream that will give result.
// Stream can not be used after terminal operation has been called.
public class TerminalOperationsExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

//       1. collect / toList
        List<Integer> collect1 = list.stream().skip(1).collect(Collectors.toList());
        List<Integer> collect2 = list.stream().skip(1).toList();
        System.out.println(collect2);

//       2. forEach, forEachOrdered - works with parallel streams
//        it mains the order of elements in parallel streams
        list.stream().forEach((x) -> System.out.println(x));
        System.out.println("Parallel stream with forEach:");
        list.parallelStream().forEach((x) -> System.out.println(x));
        System.out.println("Parallel stream with forEachOrdered:");
        list.parallelStream().forEachOrdered((x) -> System.out.println(x));

//       3. reduce: Combines elements to produce single result
//        also called as aggregator
        Optional<Integer> reduce = list.stream().reduce((x, y) -> x * y);
        System.out.println("Reduce Multiply: " + reduce.get());

//       4. count
        System.out.println(list.stream().skip(2).count());

//       5. anyMatch, allMatch, noneMatch
        boolean b = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println("Any even numbers: " + b);

        boolean b1 = list.stream().allMatch(x -> x % 2 == 1);
        System.out.println("All odd number: " + b1);

        boolean b2 = list.stream().noneMatch(x -> x < 0);
        System.out.println("No number less than zero: " + b2);

//       6. findFirst, findAny
        Optional<Integer> first = list.stream().findFirst();
        System.out.println("First: " + first.get());

        Optional<Integer> any = list.stream().findAny();
        System.out.println("Any: " + any.get());

//       7. toArray()
        Object[] array = Stream.of(1, 2, 3, 4).toArray();

//       8. min, max
        long min = Stream.of(9, 5, 2).min(Comparator.naturalOrder()).get();
//        this is actually min due to custom comparator
        long max = Stream.of(9, 5, 2).max((x, y) -> y - x).get();
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}
