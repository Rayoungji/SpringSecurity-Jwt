package com.example.global.jwt.exception;

import com.example.global.exception.NotFoundException;

public class TokenHasExpiredException extends NotFoundException {

    public TokenHasExpiredException(){
        super("Token has Expired");
    }
}
