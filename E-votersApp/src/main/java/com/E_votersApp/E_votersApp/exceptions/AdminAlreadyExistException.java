package com.E_votersApp.E_votersApp.exceptions;

public class AdminAlreadyExistException extends RuntimeException {
    public AdminAlreadyExistException() {
        super("Admin already Exist");
    }
}
