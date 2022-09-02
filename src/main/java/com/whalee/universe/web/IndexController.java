package com.whalee.universe.web;

import com.htbeyond.pretask.domain.user.Member;
import com.htbeyond.pretask.domain.user.dto.MemberFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")
    public String goLoginPage(Model model){

        AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();

        if(trustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication())){
            return "/user/login";
        }else{
            return "/board/myDetailInfo";
        }
    }

    @GetMapping("/user/register")
    public String goRegisterPage(Model model){
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "/user/register";
    }

    @GetMapping("/user/loginError")
    public String goLoginErrorPage(Model model){
        return "/user/loginError";
    }

    @GetMapping("/user/mypage")
    public String goMyDetailInfoPage(Model model){
        return "/board/myDetailInfo";
    }

    @GetMapping("/board/myOrder")
    public String goMyOrderListPage(Model model){
        Member member = loginMemberInfo();
        model.addAttribute("myInfo", member);
        return "/board/myOrderList";
    }

    @GetMapping("/board/otherOrder")
    public String goOtherOrderListPage(Model model){
        Member member = loginMemberInfo();
        model.addAttribute("myInfo", member);
        return "/board/otherOrderList";
    }

    @GetMapping("/user/api/usage")
    public String goSwaggerAPIUsage(){
        return "redirect:/swagger-ui/index.html";
    }

    private Member loginMemberInfo(){
        return (Member)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
