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
