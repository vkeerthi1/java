package com.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/*The real cause of ConcurrentModfiicationException is inconsistent modCount.
// When you are iterating over ArrayList then Iterator's next() method keep track of modCount.
// If you modify the collection by adding or removing elements then modCount will change and
// it will not match with the expected modCount,
// hence Iterator will throw ConcurrentModificationException*/

//Solution: Use Iterator if you are doing it on the single-threaded environment,
// otherwise use concurrent collection classes
// e.g. CopyOnWriteArrayList to remove elements while you are looping over it.

public class ConcurrentModification {
    public static void main(String args[]) {
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        for (Integer integer : integers) { //thows in this place
            //integers.remove(1);
        }

        for (Iterator<Integer> iterator = integers.iterator(); iterator.hasNext();) {
            Integer integer = iterator.next();
            if(integer == 2) {
                iterator.remove();
            }
        }


        List<Integer> integerss  = new ArrayList<Integer>();
        integers.add(1);
        integers.add(2);
        integers.add(3);


        integerss.removeIf(i -> i == 2);

        integers.stream().filter(i -> i!=2).map(Objects::toString).collect(Collectors.toList());
    }
}
