package com.example.global.jwt.exception;

import com.example.global.exception.ForbiddenException;
import com.example.global.exception.NotFoundException;

public class TokenHasExpiredException extends ForbiddenException {

    public TokenHasExpiredException(){
        super("Token has Expired");
    }
}
