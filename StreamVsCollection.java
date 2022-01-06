package com.ds.string;

import java.util.ArrayList;
import java.util.stream.Stream;


//1n other words, Java constructs a Collection eagerly by computing all the elements at the beginning. Hence, a Collection with a large result
// set puts a lot of pressure on the heap memory in materialization.
// Therefore, we should consider a Collection to render a result set that doesn't put much pressure on the heap memory for its materialization.

//Fixed Format
// We can use a Collection to enforce a consistent result set for the user.
// For instance, Collections like TreeSet and TreeMap return naturally ordered results.
// In other words, with the use of the Collection, we can ensure each consumer receives and processes the same result set in identical order.

//4.3. Reuseable Result
//When a result is returned in the form of a Collection, it can be easily traversed multiple times.
//However, a Stream is considered consumed once traversed and throws IllegalStateException when reused:
//Therefore, returning a Collection is a better choice when it's obvious that a consumer will traverse the result multiple times.

//4.4. Modification
//A Collection, unlike a Stream, allows modification of the elements like adding or removing elements
//from the result source. Hence, we can consider using collections to return the result set to allow modifications by the consumer.


//We can conclude that Stream is a great candidate to render large or infinite result sets with benefits like lazy initialization,
// much-needed flexibility, and functional behavior.
//However, when we require a consistent form of the results, or when low materialization is involved, we should choose a Collection over a Stream.

public class StreamVsCollection {
    public static void main(String[] args) {

        ////4.3. Reuseable Result
        ArrayList<String> userNameSource = new ArrayList<>();
        userNameSource.add("john");
        userNameSource.add("smith");
        userNameSource.add("tom");

        Stream<String> userNameStream = userNameSource.stream();
        userNameStream.forEach(System.out::println);

        try {
            userNameStream.forEach(System.out::println);
        } catch (IllegalStateException e) {
            System.out.println("stream has already been operated upon or closed");
        }
    }
}
