package com.example.Proyecto.First.Commit.exception;

/**
 * Exception for the case where the received file is empty.
 */
public class InvalidSizeException extends Exception {
    public InvalidSizeException(String message) {
        super(message);
    }
}
