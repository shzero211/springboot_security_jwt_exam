package com.ll.exam.spring_security_jwt_exam.member;


import com.ll.exam.spring_security_jwt_exam.app.base.RsData;
import com.ll.exam.spring_security_jwt_exam.app.base.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    @PostMapping("/login")
    public ResponseEntity<RsData> join(@RequestBody LoginDto loginDto){

        if(loginDto.isNotValid()){
            return Util.spring.responseEntityOf(RsData.of("F-1", "로그인 정보가 올바르지 않습니다."));
        }

        Member member=memberService.findByUsername(loginDto.getUsername()).orElse(null);

        if(member==null){
            return Util.spring.responseEntityOf(RsData.of("F-2", "일치하는 회원이 존재하지 않습니다."));
        }

        if(passwordEncoder.matches(loginDto.getPassword(), member.getPassword())==false){
            return Util.spring.responseEntityOf(RsData.of("F-3", "비밀번호가 일치하지 않습니다."));
        }
        HttpHeaders headers=new HttpHeaders();
        headers.set("Authentication","JWT_Access_Token");

       String body= "usernaeme : %s , password : %s".formatted(loginDto.getUsername(),loginDto.getPassword());
        return Util.spring.responseEntityOf(RsData.of("S-1","로그인 성공Access Token을 발급합니다."),headers);
    }
}
