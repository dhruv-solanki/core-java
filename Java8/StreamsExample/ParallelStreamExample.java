package Java8.StreamsExample;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

// a type of stream that enables parallel processing on elements
// allows multiple threads to process parts of the stream simultaneously
// this can significantly improve performance for large data sets
// because workload is distributed across multiple threads
// it is most effective for CPU intensive tasks
// or for large data sets where tasks are independent
// they may add overhead for simple tasks or small data sets

// we can convert parallel stream into sequential()
public class ParallelStreamExample {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(2000).toList();
        List<Long> factorials = list.stream().map(ParallelStreamExample::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with streams: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        List<Long> factorials2 = list.parallelStream().map(ParallelStreamExample::factorial).toList();
//        List<Long> factorials2 = list.parallelStream().map(ParallelStreamExample::factorial).sequential().toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with parallel streams: " + (endTime - startTime) + " ms");

//        if you use it for dependent task then it will give unusual result
//        here cumulative sum depends on previous result means sequential order
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> cumulativeSum = nums.parallelStream().map(sum::addAndGet).toList();
        System.out.println("Expected cumulative sum: [1, 3, 6, 10, 15, 21]");
        System.out.println("Actual result with parallel stream: " + cumulativeSum);
    }

    public static long factorial(int n) {
        long res = 1;
        for(int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}
