package com.example.Proyecto.First.Commit.exception;

/**
 * Exception for the case where the received file is not of the allowed type (.jpeg, .jpg and .png)
 */
public class InvalidImageFormatException extends Exception {
    public InvalidImageFormatException(String message) {
        super(message);
    }
}
