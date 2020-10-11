package com.example.domain.auth.exception;

import com.example.global.exception.NotFoundException;

public class EmailNotFoundException extends NotFoundException {
   public EmailNotFoundException(){super("Email does not found");}
}
