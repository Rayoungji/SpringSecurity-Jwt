package com.example.global.jwt.exception;

import com.example.global.exception.NotFoundException;

public class TokenInsInvalidException extends NotFoundException {
public TokenInsInvalidException() {
    super("Token is invalid");
}
}
