package com.tms.Task_Management_System.ExceptionHandler;

public class SecurityError extends RuntimeException{
    public SecurityError(String message)
    {
        super(message);
    }
}
