package com.ll.exam.spring_security_jwt_exam.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    @PostMapping("/login")
    public String join(@RequestBody LoginDto loginDto){
        return "usernaeme : %s , password : %s".formatted(loginDto.getUsername(),loginDto.getPassword());
    }
}
