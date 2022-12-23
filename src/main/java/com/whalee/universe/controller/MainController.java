package com.whalee.universe.controller;

import com.whalee.universe.domain.user.dto.MemberFormDto;
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
            return "/login/index";
        }else{
            return "/board/myDetailInfo";
        }
    }

    @GetMapping("/user/register")
    public String goRegisterPage(Model model){
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "/login/register";
    }

    @GetMapping("/user/loginError")
    public String goLoginErrorPage(Model model){
        return "/login/loginError";
    }
}
