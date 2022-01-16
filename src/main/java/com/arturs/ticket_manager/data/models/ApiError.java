package com.arturs.ticket_manager.data.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class ApiError {
    private String message;
    private List<String> errors;

    public ApiError(String message, List<String> errors) {
        this.message = message;
        this.errors = errors;
    }

    public ApiError(String message, String error) {
        this.message = message;
        errors = Arrays.asList(error);
    }
}

