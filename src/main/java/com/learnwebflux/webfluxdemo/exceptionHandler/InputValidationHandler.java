package com.learnwebflux.webfluxdemo.exceptionHandler;

import com.learnwebflux.webfluxdemo.dto.InputFailedValidationResponse;
import com.learnwebflux.webfluxdemo.dto.Response;
import com.learnwebflux.webfluxdemo.exception.InputValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InputValidationHandler {
    @ExceptionHandler(InputValidationException.class)
    public ResponseEntity<InputFailedValidationResponse> handleInputValidationException(InputValidationException ex){
        InputFailedValidationResponse response = InputFailedValidationResponse.builder()
                .errorCode(ex.getErrorCode())
                .input(ex.getInput())
                .message(ex.getMessage())
                .build();

        return ResponseEntity.badRequest().body(response);

    }
}
