//package com.whalee.universe.web;
//
//import com.whalee.universe.domain.user.Member;
//import com.whalee.universe.domain.user.dto.MemberFormDto;
//import com.whalee.universe.service.user.MemberService;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationTrustResolver;
//import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import springfox.documentation.annotations.ApiIgnore;
//
//import javax.validation.Valid;
//
//@ApiIgnore
//@RequiredArgsConstructor
//@Controller
//public class IndexController {
//
//    private final MemberService memberService;
//    private final PasswordEncoder passwordEncoder;
//
//    @GetMapping("/")
//    public String goLoginPage(Model model){
//
//        AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();
//
//        if(trustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication())){
//            return "/user/login";
//        }else{
//            return "/board/myDetailInfo";
//        }
//    }
//
//    @GetMapping("/user/register")
//    public String goRegisterPage(Model model){
//        model.addAttribute("memberFormDto", new MemberFormDto());
//        return "/user/register";
//    }
//
//    @GetMapping("/user/loginError")
//    public String goLoginErrorPage(Model model){
//        return "/user/loginError";
//    }
//
//    @GetMapping("/user/mypage")
//    public String goMyDetailInfoPage(Model model){
//        return "/board/myDetailInfo";
//    }
//
//    @GetMapping("/board/myOrder")
//    public String goMyOrderListPage(Model model){
//        Member member = loginMemberInfo();
//        model.addAttribute("myInfo", member);
//        return "/board/myOrderList";
//    }
//
//    @GetMapping("/board/otherOrder")
//    public String goOtherOrderListPage(Model model){
//        Member member = loginMemberInfo();
//        model.addAttribute("myInfo", member);
//        return "/board/otherOrderList";
//    }
//
//    @GetMapping("/user/api/usage")
//    public String goSwaggerAPIUsage(){
//        return "redirect:/swagger-ui/index.html";
//    }
//
//    private Member loginMemberInfo(){
//        return (Member)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    }
//
//    @ApiOperation(value="회원가입 API", notes="정해진 유효성 검사 후 통과 시 DB에 Member 정보를 등록하고 페이지 redirect")
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "API 정상 작동"),
//            @ApiResponse(code = 500, message = "서버 에러")
//    })
//    @PostMapping("/api/user/register")
//    public String memberForm(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model){
//        if(bindingResult.hasErrors()){
//            return "/user/register";
//        }
//
//        try{
//            Member member = Member.createMember(memberFormDto, passwordEncoder);
//            memberService.saveMember(member);
//        }catch (IllegalStateException e){
//            model.addAttribute("errorMessage", e.getMessage());
//            return "/user/register";
//        }
//
//        return "redirect:/";
//    }
//
//}
