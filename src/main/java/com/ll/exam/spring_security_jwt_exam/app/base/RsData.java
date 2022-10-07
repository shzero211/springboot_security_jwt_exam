package com.ll.exam.spring_security_jwt_exam.app.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ll.exam.spring_security_jwt_exam.member.MemberContext;
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
    public static <T> RsData<T> of(String resultCode,String msg,T data){
        return new RsData<>(resultCode,msg,data);
    }

    public static <T> RsData<T> of(String resultCode,String msg){
        return of(resultCode,msg,null);
    }

    public boolean isSuccess(){
    return resultCode.startsWith("S-1");
    }

    public boolean isFail(){
        return isSuccess()==false;
    }

    public static <T> RsData<T> successOf(T data) {
        return of("S-1", "성공", data);
    }

    public static <T> RsData<T> failOf(T data) {
        return of("F-1", "실패", data);
    }
}
