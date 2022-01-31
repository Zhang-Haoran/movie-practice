package com.jiangren.movie.expection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleBadRequest(Exception exception, WebRequest request){
        return new ResponseEntity<>(new ErrorMessage(exception.getMessage(), request.getDescription(false)), HttpStatus.BAD_REQUEST);
    }
}
