package com.home;

import java.util.Optional;

/*
The purpose of the class is to provide a type-level solution for representing optional values instead of null references
 */
public class optionalBasics {
    public static void main(String[] args) {
        //To create an empty Optional object, we simply need to use its empty() static method:
        Optional<String> empty = Optional.empty();
        System.out.println(empty.isPresent());

        String name = "baeldung";
        Optional<String> opt = Optional.of(name);
        System.out.println(opt.isPresent());

        //By doing this, if we pass in a null reference, it doesn't throw an exception
        //but rather returns an empty Optional object:
        String names = null;//"baeldung";
        Optional<String> opts = Optional.ofNullable(names);
        System.out.println(opts.isPresent());

        //3 way
        if (name != null) {
            System.out.println(name.length());
        }
        Optional<String> opt1 = Optional.of("baeldung");
        opt1.ifPresent(name11 -> System.out.println(name11.length()));
        //The orElse() method is used to retrieve the value wrapped inside an Optional instance. It takes one parameter,
        // which acts as a default value. The orElse() method returns the wrapped value if it's present,
        // and its argument otherwise:
        String nullName = null;
        System.out.println(Optional.ofNullable(nullName).orElse("john"));

        String nullNames = null;
        System.out.println(Optional.ofNullable(nullNames).orElseGet(() -> "john"));

        //////orElse with a function
        String text = null;
        String defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        System.out.println(defaultText);
        //defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);

    }

    public static String getMyDefault() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }
    /*
    false
true
false
8
8
john
john
Getting Default Value
Default Value
     */
}
