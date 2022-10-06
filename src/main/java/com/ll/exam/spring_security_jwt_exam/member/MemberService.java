package com.ll.exam.spring_security_jwt_exam.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public Member join(String username,String password,String email){
        Member member=Member.builder()
                .username(username)
                .password(password)
                .email(email)
                .build();
    memberRepository.save(member);
    return member;
    }

    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }
}
