package com.ronan.talestore.controller.exceptions;

public class StandardError {
    private long timestamp;
    private Integer status;
    private String error;


    public StandardError() {
    }

    public StandardError(long timestamp, Integer status, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
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

    public StandardError timestamp(long timestamp) {
        setTimestamp(timestamp);
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
