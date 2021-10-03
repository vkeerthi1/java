package com.home;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBasics {
    public static void main(String[] args) {
        Stream<String> st = Stream.iterate("", (str) -> str + "x");
        System.out.println(st.limit(3).map(str -> str + "y"));

        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();
        //filter(); this produces a new stream that contains elements of the original stream that pass a given test (specified by a Predicate).
        System.out.println(streamOfCollection.filter(element -> element.contains("b"))
                .collect(Collectors.toList()));
        //And we can create a stream from individual objects using Stream.of():
        Stream.of("g", "h", "i");
        //
        Stream.Builder<String> empStreamBuilder = Stream.builder();

        empStreamBuilder.accept("arrayOfEmps[0]");
        empStreamBuilder.accept("arrayOfEmps[1]");
        empStreamBuilder.accept("arrayOfEmps[2]");
        empStreamBuilder.accept("arrayOfEmps[3]");
        empStreamBuilder.accept("arrayOfEmps[4]");
        empStreamBuilder.accept("arrayOfEmps[5]");
        empStreamBuilder.accept("arrayOfEmps[6]");
        empStreamBuilder.accept("arrayOfEmps[7]");

        Stream<String> empStream = empStreamBuilder.build();

        //forEach() is simplest and most common operation; it loops over the stream elements, calling the supplied function on each element.

        //map() produces a new stream after applying a function to each element of the original stream. The new stream could be of different type

        //We saw how collect() works in the previous example; its one of the common ways to get stuff out of the stream once we are done with all the processing:

        //short-circuiting operations. Short-circuiting operations allow computations on infinite streams to complete in finite time:
        List<String> collect = empStream.skip(2).limit(5).collect(Collectors.toList());
        System.out.println(collect);

        //Comparison Based Stream Operations
        //sorted
        //Let’s start with the sorted() operation – this sorts the stream elements based on the comparator passed we pass into it.

        //distinct() does not take any argument and returns the distinct elements in the stream, eliminating duplicates. It uses the equals() method of the elements to decide whether two elements are equal or not:
        List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
        List<Integer> distinctIntList = intList.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctIntList);

        //allMatch, anyMatch, and noneMatch
        //
        //These operations all take a predicate and return a boolean. Short-circuiting is applied and processing is stopped as soon as the answer is determined
        // allMatch() checks if the predicate is true for all the elements in the stream. Here, it returns false as soon as it encounters 5, which is not divisible by 2.
        //anyMatch() checks if the predicate is true for any one element in the stream. Here, again short-circuiting is applied and true is returned immediately after the first element.
        //noneMatch() checks if there are no elements matching the predicate. Here, it simply returns false as soon as it encounters 6, which is divisible by 3.
        List<Integer> intist = Arrays.asList(2, 4, 5, 6, 8);

        boolean allEven = intist.stream().allMatch(i -> i % 2 == 0);
        System.out.println(allEven);
        boolean oneEven = intist.stream().anyMatch(i -> i % 2 == 0);
        System.out.println(oneEven);
        boolean noneMultipleOfThree = intist.stream().noneMatch(i -> i % 3 == 0);
        System.out.println(noneMultipleOfThree);

        ///Advanced collect
        //We already saw how we used Collectors.toList() to get the list out of the stream. Let’s now see few more ways to collect elements from the stream.
        //joining
        Collection<String> collections = Arrays.asList("a", "b", "c");
        Stream<String> streamOf = collections.stream();
        String empNames = streamOf.collect(Collectors.joining("# ")).toString();
        System.out.println(empNames);


        List<Integer> iList = Arrays.asList(2, 4, 5, 6, 8);
        Map<Boolean, List<Integer>> isEven = iList.stream().collect(
                Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println(isEven.get(true));
        System.out.println(isEven.get(false));


        //Parallel Streams
        //Using the support for parallel streams, we can perform stream operations in parallel without having to write any boilerplate code; we just have to designate the stream as parallel:
        //terate() takes two parameters: an initial value, called seed element and a function which generates next element using the previous value. iterate(), by design, is stateful and hence may not be useful in parallel streams:
        Stream<Integer> evenNumStream = Stream.iterate(2, i -> i * 2);
        //Here, we pass 2 as the seed value, which becomes the first element of our stream. This value is passed as input to the lambda, which returns 4. This value, in turn, is passed as input in the next iteration.
        //This continues until we generate the number of elements specified by limit() which acts as the terminating condition.
        List<Integer> collectss = evenNumStream
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(collectss);
    }
/*
Answers for above:
java.util.stream.ReferencePipeline$3@2752f6e2
[b]
[arrayOfEmps[2], arrayOfEmps[3], arrayOfEmps[4], arrayOfEmps[5], arrayOfEmps[6]]
[2, 5, 3, 4]
false
true
false
a# b# c
[2, 4, 6, 8]
[5]
[2, 4, 8, 16, 32]
*/
}
