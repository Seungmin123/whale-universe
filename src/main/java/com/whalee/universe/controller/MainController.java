package com.whalee.universe.controller;

import com.whalee.universe.common.enums.urls.URLCode;
import com.whalee.universe.model.member.dto.MemberFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MainController {

    @GetMapping("/")
    public String goLoginPage(Model model){

        AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();

        if(trustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication())){
            return URLCode.MEMBER_LOGIN.getUrl();
        }else{
            return URLCode.MEMBER_DETAIL.getUrl();
        }
    }

    @GetMapping("/user/register")
    public String goRegisterPage(Model model){
        model.addAttribute("memberFormDto", new MemberFormDto());
        return URLCode.MEMBER_REGIST.getUrl();
    }

    @GetMapping("/member/detail")
    public String goDetailPage(Model model){
        model.addAttribute("memberFormDto", new MemberFormDto());
        return URLCode.MEMBER_DETAIL.getUrl();
    }
}
