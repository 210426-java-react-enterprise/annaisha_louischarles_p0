package com.revature.intro.util;

public interface Queue<T> extends Collection<T> {

    T poll();
    T peek();

}
