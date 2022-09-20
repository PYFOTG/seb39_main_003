package com.web.MyPetForApp.exception.handler;


import com.web.MyPetForApp.exception.error.FileCountExceedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    protected ResponseEntity handleFileCountExceededException(FileCountExceedException e) {
        return null;
    }
}
