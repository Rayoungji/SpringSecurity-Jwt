package com.example.domain.auth.exception;

import com.example.global.exception.NotFoundException;

public class PasswordMismatchException extends NotFoundException {
    public PasswordMismatchException() {
        super("PassWord is Incorrect");
    }
}
