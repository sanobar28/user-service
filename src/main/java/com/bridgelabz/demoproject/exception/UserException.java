package com.bridgelabz.demoproject.exception;

public class UserException extends RuntimeException{

    public String message;
    public ExceptionType type;

    public UserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public enum ExceptionType {
        USER_NOT_FOUND
    }

}
