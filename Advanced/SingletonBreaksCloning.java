package com.java;

class SuperClass implements Cloneable {
    int i = 10;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

// Singleton class
class Singletonc extends SuperClass{
    // public instance initialized when loading the class
    public static Singletonc instance = new Singletonc();

    private Singletonc() {
        // private constructor
    }
}

public class SingletonBreaksCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        Singletonc instance1 = Singletonc.instance;
        Singletonc instance2 = (Singletonc) instance1.clone();
        System.out.println("instance1 hashCode:- "
                + instance1.hashCode());
        System.out.println("instance2 hashCode:- "
                + instance2.hashCode());
    }
}
//    To overcome this issue, override clone() method and throw an exception from clone method
//    that is CloneNotSupportedException.
//    Now whenever user will try to create clone of singleton
//    object, it will throw exception and hence our class remains singleton.

// Singleton class
class Singletoncc extends SuperClass
{
    // public instance initialized when loading the class
    public static Singletoncc instance = new Singletoncc();

    private Singletoncc()
    {
        // private constructor
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
        //or return instance;
    }
}
