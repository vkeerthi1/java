package com.ds.string;

interface Shape {
}

final class Rectangle implements Shape {
    final double length;
    final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double length() {
        return length;
    }

    double width() {
        return width;
    }
}

class Circle implements Shape {
    final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    double radius() {
        return radius;
    }

}

public class TrialInstanceMatch {
    public static void main(String[] args) {

    }

    public static double getPerimeter(Shape shape) throws IllegalArgumentException {
        if (shape instanceof Rectangle) {
            Rectangle s = (Rectangle) shape;
            return 2 * s.length() + 2 * s.width();
        } else if (shape instanceof Circle) {
            Circle s = (Circle) shape;
            return 2 * s.radius() * Math.PI;
        } else {
            throw new IllegalArgumentException("Unrecognized shape");
        }
    }
}
//JAVA 15
//Pattern matching enables you to remove the conversion step by changing the second operand of the instanceof operator with a type test pattern,
//making your code shorter and easier to read:


 /*   public static double getPerimeterJava9(Shape shape) throws IllegalArgumentException {
        if (shape instanceof Rectangle s){
            return 2 * s.length() + 2 * s.width();
            // You can use the binding variable s (of type Rectangle) here.
        }
        else if (shape instanceof Circle s){
            // You can use the binding variable s of type Circle here
            // but not the binding variable s of type Rectangle.
            return 2 * s.radius() * Math.PI;
        } else{
            throw new IllegalArgumentException("Unrecognized shape");
        }
    }

    public static boolean bigEnoughRect(Shape s) {
        if (!(s instanceof Rectangle r)){
            // You cannot use the binding variable r here.
            return false;
        }
        // You can use r here.
        return r.length() > 5;
    }

    //You can use a binding variable in the expression of an if statement:
     if(shape instanceof Rectangle s && s.length()>5)
    {

    }*/
