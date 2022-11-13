package com.assessment.ecommerce.Comman;

public class Message {
    private final boolean status;
    private final String message;

    public Message(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
