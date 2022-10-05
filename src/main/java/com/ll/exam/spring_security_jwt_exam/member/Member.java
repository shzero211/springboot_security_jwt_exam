package com.ll.exam.spring_security_jwt_exam.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ll.exam.spring_security_jwt_exam.app.base.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Member extends BaseEntity {
    @Column(unique = true)
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    public Member(long id){
        super(id);
    }
    public Collection<? extends GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("MEMBER"));
        return authorities;
    }
}
