package com.example.domain.auth.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LogInRequest {
    private String email;
    private String pwd;
}
