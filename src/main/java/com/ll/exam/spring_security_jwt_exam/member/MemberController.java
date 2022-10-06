package com.ll.exam.spring_security_jwt_exam.member;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/member")
public class MemberController {
    @PostMapping("/login")
    public ResponseEntity<String> join(@RequestBody LoginDto loginDto){
        HttpHeaders headers=new HttpHeaders();
        headers.set("Authentication","JWT키");
       String body= "usernaeme : %s , password : %s".formatted(loginDto.getUsername(),loginDto.getPassword());
       return new ResponseEntity<>(body,headers, HttpStatus.OK);
    }
}
