package com.E_votersApp.E_votersApp.exceptions;

public class EmployeeDoesNotExistException extends RuntimeException {
    public EmployeeDoesNotExistException() {
        super("Employee does not Exist");
    }
}
