package com.example.domain.auth.exception;

import com.example.global.exception.NotFoundException;

public class EmailNotFoundException extends NotFoundException {
    public EmailNotFoundException(){
        this("Member does not found");
    }
    public EmailNotFoundException(String message){
        super(message);
    }
}
