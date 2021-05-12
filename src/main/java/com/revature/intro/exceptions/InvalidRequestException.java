package com.revature.intro.exceptions;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(String message) {
        super("This is not a valid request" +message);

    }
}
