package com.E_votersApp.E_votersApp.exceptions;

public class InvalidPollOptionException extends RuntimeException {
    public InvalidPollOptionException() {
        super("Option not part of poll options");
    }
}
