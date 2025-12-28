package com.E_votersApp.E_votersApp.exceptions;

public class PollDoesNotExistException extends RuntimeException {
    public PollDoesNotExistException() {
        super("Poll Does Not Exist");
    }
}
