package com.ronan.talestore.controller.exceptions;

import java.time.LocalDateTime;

public class StandardError {
    private LocalDateTime timeStamp;
    private Integer status;
    private String error;


    public StandardError() {
    }

    public StandardError(LocalDateTime timeStamp, Integer status, String error) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
    }

    public LocalDateTime getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
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

    public StandardError timeStamp(LocalDateTime timeStamp) {
        setTimeStamp(timeStamp);
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
