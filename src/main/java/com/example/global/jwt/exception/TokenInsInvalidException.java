package com.example.global.jwt.exception;

import com.example.global.exception.ForbiddenException;
import com.example.global.exception.NotFoundException;

public class TokenInsInvalidException extends ForbiddenException {
public TokenInsInvalidException() {
    super("Token is invalid");
}
}
