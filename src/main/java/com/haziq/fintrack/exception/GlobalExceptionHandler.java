package com.haziq.fintrack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
// global error handler for all controllers
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    // handle validation errors
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    // return HTTP 400
    public Map<String, String> handleValidationErrors(

            MethodArgumentNotValidException ex
    ) {

        // create map for error messages
        Map<String, String> errors = new HashMap<>();

        // loop through all validation errors
        ex.getBindingResult().getFieldErrors().forEach(error -> {

            // field name
            String fieldName = error.getField();

            // validation message
            String errorMessage = error.getDefaultMessage();

            // save into map
            errors.put(fieldName, errorMessage);
        });

        // return clean JSON response
        return errors;
    }
}