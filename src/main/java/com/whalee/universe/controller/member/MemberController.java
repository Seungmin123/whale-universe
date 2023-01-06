package com.whalee.universe.controller.member;

import com.whalee.universe.common.exception.ExceptionCode;
import com.whalee.universe.domain.member.Member;
import com.whalee.universe.domain.member.dto.MemberFormDto;
import com.whalee.universe.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerMember(@RequestBody @Valid MemberFormDto memberFormDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/user/register";
        }

        try{
            Member member = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(member);
        }catch (IllegalStateException e){
            return ExceptionCode.MEMBER_LOGIN_FAIL.getMessageByCode(e.getMessage());
        }catch (Exception e){
            return ExceptionCode.MEMBER_LOGIN_FAIL.getMessageByCode(e.getMessage());
        }

        return "/";
    }
}
