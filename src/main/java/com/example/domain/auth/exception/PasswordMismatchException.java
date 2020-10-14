package com.example.domain.auth.exception;

import com.example.global.exception.ForbiddenException;

public class PasswordMismatchException extends ForbiddenException {
    public PasswordMismatchException() {
        super("PassWord is Incorrect");
    }
}
