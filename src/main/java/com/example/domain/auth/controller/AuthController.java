package com.example.domain.auth.controller;

import com.example.domain.auth.request.LogInRequest;
import com.example.domain.auth.response.LogInResponse;
import com.example.domain.auth.service.AuthService;
import com.example.domain.member.entity.Member;
import com.example.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final MemberRepository memberRepository;
    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/signIn/{email}/{pwd}/{role}")
    public Member signIn(@PathVariable String email, @PathVariable String pwd, @PathVariable String role) {
        Member member = Member.builder()
                .email(email)
                .pwd(passwordEncoder.encode(pwd))
                .role(role).build();
        return memberRepository.save(member);
    }

    @PostMapping("/logIn")
    public LogInResponse logIn(@RequestBody LogInRequest logInRequest){
        return authService.logIn(logInRequest);
    }

    @GetMapping("/accessToken")
    public String requestAccessToken(@RequestHeader String refreshToken) {
        String accessToken = authService.getAccessTokeBy(refreshToken);
        return accessToken;
    }
}
