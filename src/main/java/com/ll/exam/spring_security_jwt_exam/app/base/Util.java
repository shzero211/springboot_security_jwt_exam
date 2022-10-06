package com.ll.exam.spring_security_jwt_exam.app.base;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Util {
    public  class spring{
        public static <T> ResponseEntity<RsData> responseEntityOf(RsData<T>rsData){
            return responseEntityOf(rsData,null);
        }
        public static <T>ResponseEntity<RsData> responseEntityOf(RsData<T> rsData,HttpHeaders headers){
            return new ResponseEntity<>(rsData,headers,rsData.isSuccess()?HttpStatus.OK:HttpStatus.BAD_REQUEST);
        }
    }
}
