package com.ll.exam.spring_security_jwt_exam.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    private String username;
    private String password;

    public boolean isNotValid() {
        return username==null|| password==null||username.trim().length()==0||password.trim().length()==0;
    }
}
