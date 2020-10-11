package com.example.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundException extends ResponseStatusException {
    public NotFoundException(){
        this("Not Found Exception");
    }
    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND,message);
    }
}
