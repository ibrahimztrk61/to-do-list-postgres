package com.ibrahim.todolistpostgres.exceptions;

public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(){
        super("Task not found by given task id");
    }
}
