package com.ll.exam.spring_security_jwt_exam.app.base;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Util {
    public  class spring{
        public static <T>ResponseEntity<T> responseEntityOf(HttpHeaders headers){
            return new ResponseEntity<>(null,headers, HttpStatus.OK);
        }
    }
}
