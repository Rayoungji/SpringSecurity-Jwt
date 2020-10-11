package com.example.domain.auth.exception;

import com.example.global.exception.NotFoundException;

public class MemberNotFoundException extends NotFoundException {
    public MemberNotFoundException() {
        super("PassWord is Incorrect");
    }
}
