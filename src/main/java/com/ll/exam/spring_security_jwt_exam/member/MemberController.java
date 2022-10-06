package com.ll.exam.spring_security_jwt_exam.member;


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
    public ResponseEntity<String> join(@RequestBody LoginDto loginDto){

        if(loginDto.isNotValid()){
        return new ResponseEntity<>(null,null,HttpStatus.BAD_REQUEST);
        }

        Member member=memberService.findByUsername(loginDto.getUsername()).orElse(null);

        if(member==null){
            return new ResponseEntity<>(null,null,HttpStatus.BAD_REQUEST);
        }

        if(passwordEncoder.matches(loginDto.getPassword(), member.getPassword())==false){
            return new ResponseEntity<>(null,null,HttpStatus.BAD_REQUEST);
        }
        HttpHeaders headers=new HttpHeaders();
        headers.set("Authentication","JWT_Access_Token");
       String body= "usernaeme : %s , password : %s".formatted(loginDto.getUsername(),loginDto.getPassword());
        return Util.spring.responseEntityOf(headers);
    }
}
