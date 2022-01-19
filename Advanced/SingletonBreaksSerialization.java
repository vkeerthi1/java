package com.java;


import java.io.*;

class Singletonn implements Serializable {
    // public instance initialized when loading the class
    public static Singletonn instance = new Singletonn();

    private Singletonn() {
        // private constructor
    }
}

public class SingletonBreaksSerialization {
    public static void main(String[] args) {
        try {
            Singletonn instance1 = Singletonn.instance;
            ObjectOutput out
                    = new ObjectOutputStream(new FileOutputStream("file.text"));
            out.writeObject(instance1);
            out.close();

            // deserialize from file to object
            ObjectInput in
                    = new ObjectInputStream(new FileInputStream("file.text"));

            Singletonn instance2 = (Singletonn) in.readObject();
            in.close();

            System.out.println("instance1 hashCode:- "
                    + instance1.hashCode());
            System.out.println("instance2 hashCode:- "
                    + instance2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

//Overcome serialization issue:- To overcome this issue,
// we have to implement method readResolve() method.
class SingletonResolve implements Serializable {
    // public instance initialized when loading the class
    public static SingletonResolve instance = new SingletonResolve();

    private SingletonResolve() {
        // private constructor
    }

    // implement readResolve method
    protected Object readResolve() {
        return instance;
    }
}
