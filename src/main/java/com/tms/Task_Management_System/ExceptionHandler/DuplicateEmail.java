package com.tms.Task_Management_System.ExceptionHandler;

public class DuplicateEmail extends RuntimeException{
    public DuplicateEmail(String message)
    {
        super(message);
    }
}
