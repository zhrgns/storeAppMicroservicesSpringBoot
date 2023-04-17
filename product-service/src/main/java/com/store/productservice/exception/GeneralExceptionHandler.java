package com.store.productservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionTemplate> handleException(ProductNotFoundException exception) {
        ExceptionTemplate temp = getExceptionTemplate(exception.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(temp,HttpStatus.NOT_FOUND);

    }

    private ExceptionTemplate getExceptionTemplate(String message, HttpStatus status) {
        ExceptionTemplate template = new ExceptionTemplate();
        template.setExceptionMessage(message);
        template.setStatusCode(status.value());
        template.setExceptionDate(LocalDateTime.now());
        return template;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class ExceptionTemplate {
        private int statusCode;
        private String exceptionMessage;
        private LocalDateTime exceptionDate;
    }
}

