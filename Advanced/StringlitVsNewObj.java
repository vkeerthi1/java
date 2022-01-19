package com.java;

/*
* At a high level both are String objects,
*  but the main difference comes from the point that the new() operator always
*  creates a new String object.
* Also when you create String using literal they are interned.
*/

public class StringlitVsNewObj {

    public static void main(String args[]) {
        String a = "Java"; String b = "Java";
        System.out.println(a == b); // True

        String c = new String("Java");
        String d = new String("Java");
        System.out.println(c == d); // False


        String e = "JDK";
        String f = new String("JDK");
        System.out.println(e == f); // False


        f =f.intern();
        System.out.println(e == f); // False
    }
}
