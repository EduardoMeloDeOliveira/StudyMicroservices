package com.ms.user.execption.handlers;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlers {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handlderEntityNotFoundException(EntityNotFoundException ex) {

        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
