package com.example.Proyecto.First.Commit.exception;

/**
 * Exception for the case where the received file is empty.
 */
public class EmptyImageException extends Exception {
    public EmptyImageException(String message) {
        super(message);
    }
}
