package com.home;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class predicateBasics {

    public static void main(String[] args) {
        //In Java 8, Predicate is a functional interface, which accepts an argument and returns a boolean. Usually, it used to apply in a filter for a collection of objects.
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> collect = list.stream().filter(x -> x > 5).collect(Collectors.toList());
        System.out.println(collect); // [6, 7, 8, 9, 10]

        //predicate
        Predicate<Integer> noGreaterThan5 = x -> x > 5;

        List<Integer> lt = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> collect1 = lt.stream()
                .filter(noGreaterThan5)
                .collect(Collectors.toList());

        System.out.println(collect1); // [6, 7, 8, 9, 10]


        //2. Predicate.and()

        //2.1 Multiple filters.
        List<Integer> lists = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // multiple filters
        List<Integer> collects = lists.stream()
                .filter(x -> x > 5 && x < 8).collect(Collectors.toList());

        System.out.println(collects);

        Predicate<Integer> noGreaterThan5_ = x -> x > 5;
        Predicate<Integer> noLessThan8 = x -> x < 8;

        List<Integer> listss = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> collectss = listss.stream()
                .filter(noGreaterThan5_.and(noLessThan8))
                .collect(Collectors.toList());

        System.out.println(collectss);

        //OR
        Predicate<String> lengthIs3 = x -> x.length() == 3;
        Predicate<String> startWithA = x -> x.startsWith("A");

        List<String> orL = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");

        List<String> orcollect = orL.stream()
                .filter(lengthIs3.or(startWithA))
                .collect(Collectors.toList());

        System.out.println(orcollect);//[A, AA, AAA, BBB]

        //negate
        Predicate<String> startWithANeg = x -> x.startsWith("A");

        List<String> neglist = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");

        List<String> collectneg = neglist.stream()
                .filter(startWithANeg.negate())
                .collect(Collectors.toList());

        System.out.println(collectneg);//[B, BB, BBB]

        //5. Predicate.test() in function
        List<String> listTest = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");

        System.out.println(StringProcessor.filter(
                listTest, x -> x.startsWith("A")));                    // [A, AA, AAA]

        System.out.println(StringProcessor.filter(
                listTest, x -> x.startsWith("A") && x.length() == 3)); // [AAA]

        //chaining
        Predicate<String> startWithAChain = x -> x.startsWith("a");

        // start with "a" or "m"
        boolean result = startWithAChain.or(x -> x.startsWith("k")).test("kee");
        System.out.println(result);     // true

        // !(start with "a" and length is 3)
        boolean result2 = startWithAChain.and(x -> x.length() == 3).negate().test("abc");
        System.out.println(result2);

        //more way
        List<Predicate<String>> allPredicates = new ArrayList<Predicate<String>>();
        allPredicates.add(str -> str.startsWith("A"));
        allPredicates.add(str -> str.contains("d"));
        allPredicates.add(str -> str.length() > 4);

        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");
        List<String> results = names.stream()
                .filter(allPredicates.stream().reduce(x -> true, Predicate::and))
                .collect(Collectors.toList());
        System.out.println(results);

        List<String> resultss = names.stream()
                .filter(allPredicates.stream().reduce(x -> false, Predicate::or))
                .collect(Collectors.toList());
        System.out.println(resultss);

    }

    static class StringProcessor {
        static List<String> filter(List<String> list, Predicate<String> predicate) {
            return list.stream().filter(predicate::test).collect(Collectors.toList());
        }
    }
    /*
    [6, 7, 8, 9, 10]
[6, 7, 8, 9, 10]
[6, 7]
[6, 7]
[A, AA, AAA, BBB]
[B, BB, BBB]
[A, AA, AAA]
[AAA]
true
false
[Alexander]
[Adam, Alexander]
     */
}
