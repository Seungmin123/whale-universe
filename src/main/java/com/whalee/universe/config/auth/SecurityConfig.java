package com.whalee.universe.config.auth;

import com.whalee.universe.service.user.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MemberService memberService;
    private final AuthSuccessHandler authSuccessHandler;
    private final AuthFailureHandler authFailureHandler;

    @Bean
    public BCryptPasswordEncoder encryptPassword() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(memberService).passwordEncoder(encryptPassword());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**"
                ,"/v2/api-docs",  "/configuration/ui",
                "/swagger-resources", "/configuration/security",
                "/swagger-ui.html", "/webjars/**","/swagger/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                    .headers().frameOptions().disable()
                .and()
                    .authorizeRequests() // 요청 URL에 따라 접근 권한 설정
                    .antMatchers("/", "/user/**","/api/user/**", "/swagger-resources/**", "/swagger-ui/**").permitAll() // 해당 경로들 접근 허용
                    .anyRequest().authenticated()
                .and()
                    .formLogin()// 로그인 폼은
                    .loginPage("/")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .loginProcessingUrl("/api/user/login/action") // 해당 url 요청이 오면 스프링 시큐리티가 처리
                    .successHandler(authSuccessHandler)
                    .failureHandler(authFailureHandler)
                .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/api/user/logout"))
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true) // 인증정보 지우고 세션 무효화
                    .deleteCookies("JSESSIONID")
                    .permitAll()
                .and()
                    .sessionManagement()
                    .maximumSessions(1)// 최대 세션 1
                    .maxSessionsPreventsLogin(false) // 중복 로그인 시 이전 세션 삭제
                    .expiredUrl("/loginError");
    }


}
