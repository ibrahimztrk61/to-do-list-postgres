package com.ibrahim.todolistpostgres.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(){
        super("User not found by given user id");
    }

}
