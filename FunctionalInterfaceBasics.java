package com.home;


/*
An Interface that contains exactly one abstract method is known as functional interface. It can have any number of default, static methods but can contain only one abstract method. It can also declare methods of object class.
Functional Interface is also known as Single Abstract Method Interfaces or SAM Interfaces. It is a new feature in Java, which helps to achieve functional programming approach.
 */

public class FunctionalInterfaceBasics{

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() { // anonymous class
                System.out.println("Runnable with Anonymous Class");
            }
        };
        Runnable r2 = () -> {   // lambda expression
            System.out.println("Runnable with Lambda Expression");
        };
        new Thread(r1).start();
        new Thread(r2).start();
    }

}
