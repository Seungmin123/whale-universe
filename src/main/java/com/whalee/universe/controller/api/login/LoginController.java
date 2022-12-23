package com.whalee.universe.controller.api.login;

import com.whalee.universe.domain.user.Member;
import com.whalee.universe.domain.user.dto.MemberFormDto;
import com.whalee.universe.service.user.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class LoginController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerMember(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "/user/register";
        }

        try{
            Member member = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(member);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "/user/register";
        }

        return "redirect:/";
    }
}
