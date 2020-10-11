package com.example.domain.auth.exception;

import com.example.global.exception.NotFoundException;

public class MemberNotFoundException extends NotFoundException {
    public MemberNotFoundException(){
        this("Member does not found");
    }
    public MemberNotFoundException(String message){
        super(message);
    }
}
