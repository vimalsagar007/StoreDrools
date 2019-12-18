package com.sample;

public class Message {

    public static final String HELLO = "0";
    public static final String GOODBYE = "1";

    private String message;

    private String status;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}