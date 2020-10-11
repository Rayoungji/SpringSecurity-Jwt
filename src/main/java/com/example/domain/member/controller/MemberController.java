package com.example.domain.member.controller;


import com.example.global.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class MemberController {
     private final JwtService jwtService;

    @GetMapping("/intro")
    public String intro(){
        return "This is Intro!";
    }

    @GetMapping("/user/test")
    public String userTest(@RequestHeader String accessToken){
        String email = jwtService.findEmailByToken(accessToken);
        return "Hello,user!!"+email;
    }

    @GetMapping("admin/test")
    public String adminTest(@RequestHeader String accessToken) {
        String email = jwtService.findEmailByToken(accessToken);
        return "Hello,admin!!"+email;
    }
}
