package com.ll.exam.spring_security_jwt_exam.member;


import com.ll.exam.spring_security_jwt_exam.app.base.RsData;
import com.ll.exam.spring_security_jwt_exam.app.base.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    @PostMapping("/login")
    public ResponseEntity<RsData> login(@RequestBody LoginDto loginDto){

        if(loginDto.isNotValid()){
            return Util.spring.responseEntityOf(RsData.of("F-1", "로그인 정보가 올바르지 않습니다."));
        }

        Member member=memberService.findByUsername(loginDto.getUsername()).orElse(null);

        if(member==null){
            return Util.spring.responseEntityOf(RsData.of("F-2", "일치하는 회원이 존재하지 않습니다."));
        }

        if(passwordEncoder.matches(loginDto.getPassword(), member.getPassword())==false){
            return Util.spring.responseEntityOf(RsData.of("F-3", "비밀번호가 일치하지 않습니다."));
        }
        log.debug("Util.json.toStr(member.getAccessTokenClaims()) : " + Util.json.toStr(member.getAccessTokenClaims()));

        String accessToken = memberService.genAccessToken(member);
        return Util.spring.responseEntityOf(
                RsData.of("S-1","로그인 성공 AccessToken을 발급합니다.", Util.mapOf("Authentication",accessToken))
                ,Util.spring.httpHeadersOf("Authentication",accessToken));
    }
    @GetMapping("/me")
    public ResponseEntity<RsData> me(@AuthenticationPrincipal MemberContext memberContext){
            if(memberContext==null){
                return Util.spring.responseEntityOf(RsData.failOf(null));
            }
        return Util.spring.responseEntityOf(RsData.successOf(memberContext));
    }
}
