#Sealed classes and interfaces restrict which other classes or interfaces may extend or implement them.

#To seal a class, add the sealed modifier to its declaration. Then, after any extends and implements clauses, add the permits clause. This clause specifies the classes that may extend the sealed class. 
#For example, the following declaration of Shape specifies three permitted subclasses, Circle, Square, and Rectangle: 


public sealed class Shape permits Circle, Square, Rectangle {
}

final class Circle extends Shape {
    public float radius;
}
non-sealed class Square extends Shape {
   public double side;
}   
sealed class Rectangle extends Shape permits FilledRectangle {
    public double length, width;
}
