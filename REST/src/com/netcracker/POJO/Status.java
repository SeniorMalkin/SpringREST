package com.netcracker.POJO;

public class Status {
     private String httpStatus;
     private String message;

    public Status() {
    }

    public Status(String httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Status: " + httpStatus + "; " + message;
    }
}
