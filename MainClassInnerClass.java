package com;

import com.OuterClass;

public class MainClassInnerClass {

    public static void main(String args[]) {
        OuterClass outer = new OuterClass();
        outer.heyThere();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.heyThere();

        OuterClass.Inner2Class inner2 = new OuterClass.Inner2Class();
       inner2.heyThere2();


    }
}

//Other Outer Class

public class OuterClass {
    public void heyThere() {
        System.out.println("Outer here");

        class LocalInnerClass {
            String local = "keerthi";

            public void printlocal() {
                System.out.println("local Inner here");
            }
        }
        LocalInnerClass lic = new LocalInnerClass();
        lic.printlocal();
    }

    public class InnerClass {
        public void heyThere() {
            System.out.println("Inner here");
        }
    }

    public static class Inner2Class {
        public void heyThere2() {
            System.out.println("Inner 2 here");
        }
    }
}
