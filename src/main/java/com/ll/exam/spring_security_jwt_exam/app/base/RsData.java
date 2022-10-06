package com.ll.exam.spring_security_jwt_exam.app.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RsData<T> {
    private String resultCode;
    private String msg;
    private T data;

    public static <T> RsData<T> of(String resultCode,String msg){
        return new RsData<>(resultCode,msg,null);
    }

    public boolean isSuccess(){
    return resultCode.startsWith("S-1");
    }

    public boolean isFail(){
        return isSuccess()==false;
    }
}