package com.ronan.talestore.controller.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError() {
        super();
    }

    public ValidationError(LocalDateTime timeStamp, Integer status, String error) {
        super(timeStamp, status, error);
    }

    public List<FieldMessage> getErrors() {
        return this.errors;
    }

    public void addErrors(String fieldName, String message) {
        this.errors.add(new FieldMessage(fieldName, message));
    }

}
