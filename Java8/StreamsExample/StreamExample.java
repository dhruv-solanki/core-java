package Java8.StreamsExample;

// Stream is introduced in Java8
// It process collection of data in functional and declarative manner
// Simplifies data processing
// Embraces functional programming
// Improves readability and maintainability
// Enable easy parallelism

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Stream: sequence of elements supporting sequential and parallel aggregate operations
// How to use: Source --> Intermediate operations --> terminal operation
// Stream can not be used after terminal operation has been called.
public class StreamExample {
    public static void runExamples() {
        System.out.println("Stream Examples:");
//        filter and collect names
        List<String> names = Arrays.asList("Taylor", "Bob", "Ariana", "Alicia");
        System.out.println(names.stream().filter(s -> s.length() > 3).toList());

//        squaring and sorting
        List<Integer> nums = Arrays.asList(5, 3, 8, 2, 1);
        System.out.println(nums.stream().map(x -> x * x).sorted().toList());

//        summing up
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(ints.stream().reduce(Integer::sum).get());

//        counting occurrence of char
        String sentence = "Hello World!";
        System.out.println(sentence.chars().filter(c -> c == 'l').count());
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
//        count even numbers
        int count = 0;
        for(int i: list) {
            if(i % 2 == 0) {
                count++;
            }
        }
        System.out.println("Conventional - Even numbers: " + count);

//        using stream
        long cnt = list.stream().filter(x -> x % 2 == 0).count();
        System.out.println("Stream - Even numbers: " + count);

//        How to create streams:
//        1. From collections
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = nums.stream();
//        2. From Arrays
        String[] array = {"a", "y", "c"};
        Stream<String> stream1 = Arrays.stream(array);
//        3. Using Stream.of()
        Stream<String> strStreams = Stream.of("z", "y", "x");
//        4. Infinite streams / if we remove limit then it will be of infinite size
        Stream<Integer> generate = Stream.generate(() -> 1).limit(10);
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 1).limit(11);
        System.out.println(iterate.collect(Collectors.toList()));

        runExamples();
    }
}
