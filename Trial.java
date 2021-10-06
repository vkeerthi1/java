package com.home;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Trial {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "linode.com");
        map.put(2, "heroku.com");
        map.put(3, "digitalocean.com");
        map.put(4, "aws.amazon.com");
        map.put(5, "aws2.amazon.com");


        //Map -> Stream -> Filter -> String
        String res = map.entrySet().stream().filter(x -> "something".equals(x.getValue()))
                     .map(x -> x.getValue()).collect(Collectors.joining());


        //Map -> Stream -> Filter -> MAP
        Map<Integer, String> collect = map.entrySet().stream().filter(x -> x.getKey() == 2).collect(Collectors.toMap(x -> x.getKey() , x -> x.getValue()));

        // or like this
        Map<Integer, String> collects = map.entrySet().stream()
                .filter(x -> x.getKey() == 3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        Map<Integer, String> filteredMap2 = filterByValue(map, x -> (x.contains("aws") || x.contains("linode")));
        System.out.println(filteredMap2);



    }

    public static <K, V> Map<K, V> filterByValue(Map<K, V> map, Predicate<V> predicate) {
        return map.entrySet()
                .stream()
                .filter(x -> predicate.test(x.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
