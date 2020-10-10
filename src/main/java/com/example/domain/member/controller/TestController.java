package com.example.domain.member.controller;

import com.example.domain.member.entity.Member;
import com.example.domain.member.exception.EmailNotFoundException;
import com.example.domain.member.repository.MemberRepository;
import com.example.domain.member.request.SignInRequest;
import com.example.global.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class TestController {
     private final MemberRepository memberRepository;
     private final JwtProvider jwtProvider;

    @GetMapping("/intro")
    public String intro(){
        return "This is Intro!";
    }

    @GetMapping("/signIn/{email}/{pwd}/{role}")
    public Member signIn(@PathVariable  String email, @PathVariable String pwd, @PathVariable String role) {
        Member member = Member.builder()
                .email(email)
                .pwd(pwd)
                .role(role).build();
        return memberRepository.save(member);
    }

    @PostMapping("/logIn")
    public String logIn(@RequestBody SignInRequest signInRequest){
        Member member = memberRepository.findByEmail(signInRequest.getEmail()).orElseThrow(EmailNotFoundException::new);
        return jwtProvider.generateToken(member.getEmail(),member.getRole());
    }

    @GetMapping("/user/test")
    public String userTest(@RequestHeader String token){
        String email = jwtProvider.findEmailByJwt(token);
        return "Hello,user!!"+email;
    }

    @GetMapping("admin/test")
    public String adminTest(@RequestHeader String token) {
        String email = jwtProvider.findEmailByJwt(token);
        return "Hello,admin!!"+email;
    }
}
