package com.whalee.springboot.config.auth;

import com.whalee.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                // h2-console 화면을 사용하기 위해 해당 옵션 disable
                .csrf().disable()
                .headers().frameOptions().disable()

                .and()
                    // URL별 권한 관리 설정하는 옵션의 시작점
                    // authorizeRequests가 선언되야만 andMatchers 사용가능
                    .authorizeRequests()
                    // 권한 관리 대상 지정
                    // URL, HTTP 메소드별로 관리 가능
                    // "/" 등 지정된 URL들은 permitAll() 옵션을 통해 전체 열람권한 주었음
                    // "/api/v1/**" 주소를 가진 API는 USER 권한을 가진 사람만 가능하도록 함
                    .antMatchers("/", "/css/**", "/images/**",
                            "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    // 설정 값 이외 나머지 URL
                    .anyRequest().authenticated()
                .and()
                    // 로그아웃 기능에 대한 진입점
                    // 로그아웃 성공 시 / 주소로 이동
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    // OAuth 2 로그인 기능에 대한 진입점
                    .oauth2Login()
                        // OAuth 2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들
                        .userInfoEndpoint()
                            // 소설 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스 구현체
                            // 리소스 서버(소셜 서비스)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시 가능
                            .userService(customOAuth2UserService);
    }
}
