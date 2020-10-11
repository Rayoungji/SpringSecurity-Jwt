package com.example.domain.auth.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LogInResponse {
    private String accessToken;
    private String refreshToken;

    @Builder
    public LogInResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
