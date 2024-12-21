package com.gsTech.ordermanagement.controller.handlers;

import com.gsTech.ordermanagement.dto.errors.CustomError;
import com.gsTech.ordermanagement.services.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.View;

import java.time.Instant;

import java.util.List;

@ControllerAdvice
public class ResourceExceptionHandler {

    private final View error;

    public ResourceExceptionHandler(View error) {
        this.error = error;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> productNotFound(ResourceNotFoundException e, HttpServletRequest request ) {

        CustomError err = new CustomError();

        HttpStatus status = HttpStatus.NOT_FOUND;
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }


    // retorna os erros de validaçao para o cliente
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> validationException(MethodArgumentNotValidException e) {

        List<String> errors = e.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();

        return ResponseEntity.badRequest().body(errors);
    }
}
