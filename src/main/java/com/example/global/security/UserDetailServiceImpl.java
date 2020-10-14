package com.example.global.security;

import com.example.domain.member.entity.Member;
import com.example.domain.auth.exception.MemberNotFoundException;
import com.example.domain.member.repository.MemberRepository;
import com.example.global.config.CacheKey;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Cacheable(value = CacheKey.MEMBER, key="#email", cacheManager="cacheManager")
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername is Running");
        Member member = memberRepository.findByEmail(email).orElseThrow(MemberNotFoundException::new);

        return new User(member.getEmail(), member.getPwd(),makeGrantedAuthority(member.getRole()));
    }

    private List<? extends GrantedAuthority> makeGrantedAuthority(String role) {
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_" + role));
        return list;
    }
}
