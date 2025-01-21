package com.avionics.wirelessdatatransfer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ImageNotFoundException.class)
    public ResponseEntity<String> handleImageNotFoundException(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image Not Found");
    }

    @ExceptionHandler(FileDataNotFoundException.class)
    public ResponseEntity<String> handleFileDataNotFoundException(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given File data Not Found");
    }
}
