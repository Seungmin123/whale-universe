package com.whalee.universe.controller;

import com.whalee.universe.common.enums.urls.URLCode;
import com.whalee.universe.model.member.Member;
import com.whalee.universe.model.member.dto.MemberFormDto;
import com.whalee.universe.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerMember(@RequestBody @Valid MemberFormDto memberFormDto) throws Exception{
        Member member = Member.createMember(memberFormDto, passwordEncoder);
        userService.saveMember(member);

        return URLCode.URL_ROOT.getUrl();
    }
}
