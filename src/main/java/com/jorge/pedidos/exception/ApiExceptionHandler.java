package com.jorge.pedidos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(new ErrorResponse(
                                     ex.getMessage(),
                                     HttpStatus.NOT_FOUND.value(),
                                     LocalDateTime.now()
                             ));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusiness(BusinessException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                             .body(new ErrorResponse(
                                     ex.getMessage(),
                                     HttpStatus.CONFLICT.value(),
                                     LocalDateTime.now()
                             ));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(new ErrorResponse(
                                     ex.getMessage(),
                                     HttpStatus.BAD_REQUEST.value(),
                                     LocalDateTime.now()
                             ));
    }
}
