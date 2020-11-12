package com.ibrahim.todolistpostgres.exceptions;

public class NullUserRequestException extends Exception {
    public NullUserRequestException(){
        super("User request should not be null");
    }
}
