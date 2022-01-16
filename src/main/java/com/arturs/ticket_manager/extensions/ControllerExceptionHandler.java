package com.arturs.ticket_manager.extensions;

import com.arturs.ticket_manager.data.models.ApiError;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestControllerAdvice
@Component
public class ControllerExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> handle(ConstraintViolationException exception) {

        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        List<String> errors = new ArrayList<String>();

        for (ConstraintViolation<?> violation : violations) {
            errors.add(violation.getMessage());
        }
        ApiError errorModel =  new ApiError("Validation errors encountered", errors);
        return new ResponseEntity<ApiError>(errorModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> handle(InvalidFormatException exception) {
        String error = exception.getOriginalMessage();

        ApiError errorModel =  new ApiError("Validation errors encountered", error);
        return new ResponseEntity<ApiError>(errorModel, HttpStatus.BAD_REQUEST);
    }
}
