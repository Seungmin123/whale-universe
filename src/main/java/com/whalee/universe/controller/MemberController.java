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

    @GetMapping("/memberInfo/{id}")
    public Member getMemberById(@PathVariable Long id, @AuthenticationPrincipal Member member) throws Exception {
        if(id == 0l) id = member.getId();
        return memberService.getMemberById(id);
        //
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
    public Member changeMemberInfo(@RequestBody @Valid MemberChangeReq memberChangeReq) throws Exception{
        Member member = new Member();
        member = Member.createMember(memberChangeReq, passwordEncoder);
        userService.updateMember(memberChangeReq.getId(), member);
        return member;
    }

}
