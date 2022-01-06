package com.ds.string;

import java.util.Arrays;


/* result :
        Stream without terminal operation
        Stream with terminal operation
        doubling 1
        doubling 2
        doubling 3*/

//As we can see, the intermediate operations are only triggered when a terminal operation exists.
public class StreamWithTerminal {
    public static void main(String[] args) {
        System.out.println("Stream without terminal operation");

        Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
            System.out.println("doubling " + i);
            return i * 2;
        });

        System.out.println("Stream with terminal operation");
        Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
            System.out.println("doubling " + i);
            return i * 2;
        }).sum();
    }
}
