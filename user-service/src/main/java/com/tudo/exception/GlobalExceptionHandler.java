package com.tudo.exception;

import com.tudo.payload.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> exceptionHandler(RuntimeException ex, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                ex.getMessage(),
                webRequest.getDescription(false),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.OK);
    }

}
