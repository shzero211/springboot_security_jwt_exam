package com.ll.exam.spring_security_jwt_exam.app.base;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.Map;

public class Util {
    public static <K,V> Map<K, V> mapOf(Object... args) {
        Map<K,V>map=new LinkedHashMap<>();
        int size=args.length/2;

        for(int i=0;i<size;i++){
            int keyIndex=i*2;
            int valueIndex=keyIndex+1;
            K key=(K)args[keyIndex];
            V value=(V) args[valueIndex];
            map.put(key,value);
        }

        return map;
    }

    public  class spring{
        public static <T> ResponseEntity<RsData> responseEntityOf(RsData<T>rsData){
            return responseEntityOf(rsData,null);
        }
        public static <T>ResponseEntity<RsData> responseEntityOf(RsData<T> rsData,HttpHeaders headers){
            return new ResponseEntity<>(rsData,headers,rsData.isSuccess()?HttpStatus.OK:HttpStatus.BAD_REQUEST);
        }
    }
}
