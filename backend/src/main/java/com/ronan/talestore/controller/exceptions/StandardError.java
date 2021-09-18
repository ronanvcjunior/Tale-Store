package com.ronan.talestore.controller.exceptions;

import java.time.LocalDateTime;

public class StandardError {
    private LocalDateTime localDate;
    private Integer status;
    private String error;


    public StandardError() {
    }

    public StandardError(LocalDateTime localDate, Integer status, String error) {
        this.localDate = localDate;
        this.status = status;
        this.error = error;
    }

    public LocalDateTime getLocalDate() {
        return this.localDate;
    }

    public void setLocalDate(LocalDateTime localDate) {
        this.localDate = localDate;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public StandardError localDate(LocalDateTime localDate) {
        setLocalDate(localDate);
        return this;
    }

    public StandardError status(Integer status) {
        setStatus(status);
        return this;
    }

    public StandardError error(String error) {
        setError(error);
        return this;
    }
}
