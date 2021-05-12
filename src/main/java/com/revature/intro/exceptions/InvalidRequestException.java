package com.revature.intro.exceptions;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(String message) {
<<<<<<< HEAD
        super("This is not a valid request" +message);
=======
        super(message);
>>>>>>> a810b6d56a64f769524cce173fbb1cacab1d3173
    }
}
