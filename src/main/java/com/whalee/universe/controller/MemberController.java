package com.whalee.universe.controller;

import com.whalee.universe.model.member.Member;
import com.whalee.universe.model.member.dto.MemberChangeReq;
import com.whalee.universe.model.member.dto.MemberFormDto;
import com.whalee.universe.service.member.MemberService;
import com.whalee.universe.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/myInfo")
    public Member getMyInfo(@AuthenticationPrincipal Member member) throws Exception {
        return member;
    }

    @GetMapping("/memberInfo/{id}")
    public Member getMemberById(@PathVariable Long id) throws Exception {
        return memberService.getMemberById(id);
    }

    @GetMapping("/memberInfo/name")
    public Member getMemberByName(String name) throws Exception {
        return memberService.getMemberByName(name);
    }

    @GetMapping("/memberInfo/nickName")
    public Member getMemberByNickName(String nickName) throws Exception {
        return memberService.getMemberByName(nickName);
    }

    @PatchMapping("/change")
    public Member changeMemberInfo(@RequestBody @Valid MemberChangeReq memberChangeReq){
        Member member = new Member();
        try{
            member = Member.createMember(memberChangeReq, passwordEncoder);
            userService.updateMember(memberChangeReq.getId(), member);
        }catch (Exception e){
            return new Member();
        }

        return member;
    }

}
