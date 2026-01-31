package com.tms.Task_Management_System.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateEmail.class)
    public ResponseEntity<String> duplicateEmailHandler(DuplicateEmail de)
    {
        log.error("Handling Email already register --------> ", de);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(de.getMessage());
    }

    @ExceptionHandler(DuplicateMobile.class)
    public ResponseEntity<String> duplicateMobileHandler(DuplicateMobile dm)
    {
        log.error("Handling Mobile already regiser ------------>",dm);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dm.getMessage());

    }
    @ExceptionHandler(SecurityError.class)
    public ResponseEntity<String> SecurityHandler(SecurityError se)
    {
        log.error("Handling security error --------->",se);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(se.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }
}
