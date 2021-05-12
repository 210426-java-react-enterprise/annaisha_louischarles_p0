package com.revature.intro.util;

public interface List <T> extends Collection<T> {


    void add(T data) throws IllegalArgumentException //if tail = null when list empty, if one thing in the list the head = tail are the same object, &if more than one thing
    ;

    //void add(T data);
    T get(int index);

    T poll();

    boolean contains(T data);

    // T pop();
  //  boolean contains(T data); //contains and results are true or false.
    int size();
 /*
        Interfaces
            - act as a contract for implementing classes (all concrete implementations must
              implement all abstract methods!)
            - do no have constructors
            - all fields declared within are implicitly public, static, and final
            - all method stubs declared within are implicitly public and abstract
            - methods with implementations are permitted in two ways: static and default methods
                + static methods cannot be overridden by implementing classes (but can be redeclared/shadowed)
                + default methods can be overridden by implementing classes (introduced in Java 8)
     */



}
