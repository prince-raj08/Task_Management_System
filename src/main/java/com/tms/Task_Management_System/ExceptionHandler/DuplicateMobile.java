package com.tms.Task_Management_System.ExceptionHandler;

public class DuplicateMobile extends RuntimeException{
    public DuplicateMobile(String message)
    {
        super(message);
    }
}
