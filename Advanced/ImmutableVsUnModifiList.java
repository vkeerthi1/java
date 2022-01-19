package com.java;

import java.util.*;
import java.io.*;

public class ImmutableVsUnModifiList {
   // Collections.unmodifiableList creates a wrapper around the same existing List
   // such that the wrapper cannot be used to modify it.
   // However we can still change original List.
   public static void main(String[] args) {
       List<String> lists = new ArrayList<>();
       lists.add("Geeks");

       // *********Create ImmutableList from List using copyOf()
       List<String> iList = Collections.unmodifiableList(lists);

       // We change List and the changes reflect in iList.
       lists.add("For");
       lists.add("Geeks");
       //iList.add("four"); throws error here
       System.out.println(iList);


       //*******Since Java 9, we can use a List<E>.of​(E… elements) static factory method to create an immutable list:
       final List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
       final List<String> unmodifiableList = List.of(list.toArray(new String[]{}));
       //unmodifiableList.add("four");; throws error here
       System.out.println(unmodifiableList);


       List<String> immutableList = Arrays.asList();
       //immutableList.add("hh");; throws error here
   }
}
