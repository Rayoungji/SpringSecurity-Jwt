package com.example.domain.auth.service;

import com.example.domain.auth.exception.MemberNotFoundException;
import com.example.domain.auth.exception.PasswordMismatchException;
import com.example.domain.auth.request.LogInRequest;
import com.example.domain.auth.response.LogInResponse;
import com.example.domain.member.entity.Member;
import com.example.domain.member.repository.MemberRepository;
import com.example.global.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtService jwtService;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public LogInResponse logIn(LogInRequest logInRequest) {
        Member member = memberRepository.findByEmail(logInRequest.getEmail()).orElseThrow(MemberNotFoundException::new);
        CheckPW(logInRequest.getPwd(),member.getPwd());
        String accessToken = jwtService.generateAccessTokenBy(member);
        String refreshToken = jwtService.generateRefreshToken(member);

        return LogInResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken).build();
    }

    public String getAccessTokeBy(String refreshToken) {
        String accessToken = jwtService.generateAccessTokenBy(refreshToken);
        return accessToken;
    }

    private void CheckPW(String logInPwd, String pwd) {
        if(!passwordEncoder.matches(logInPwd,pwd)){
            throw  new PasswordMismatchException();
        }
    }
}
