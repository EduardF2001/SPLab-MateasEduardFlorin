package com.example.sabloane_proiectare.command;

public class CommandResult {
    private final Object payload;
    private final boolean success;
    private final String message;

    public CommandResult(boolean success, Object payload, String message) {
        this.success = success;
        this.payload = payload;
        this.message = message;
    }

    public boolean isSuccess() {
        return !success;
    }

    public Object getPayload() {
        return payload;
    }

    public String getMessage() {
        return message;
    }
}