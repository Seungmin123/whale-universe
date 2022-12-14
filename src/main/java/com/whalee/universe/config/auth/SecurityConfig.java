package com.whalee.universe.config.auth;

import com.whalee.universe.service.user.UserService;
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

    private final UserService userService;
    private final AuthSuccessHandler authSuccessHandler;
    private final AuthFailureHandler authFailureHandler;
    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public BCryptPasswordEncoder encryptPassword() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(encryptPassword());
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
                    .authorizeRequests() // ?????? URL??? ?????? ?????? ?????? ??????
                    .antMatchers("/", "/user/**","/api/user/**", "/swagger-resources/**", "/swagger-ui/**").permitAll() // ?????? ????????? ?????? ??????
                    .anyRequest().authenticated()
                .and()
                    .formLogin()// ????????? ??????
                    .loginPage("/")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .loginProcessingUrl("/api/user/login") // ?????? url ????????? ?????? ????????? ??????????????? ??????
                    .successHandler(authSuccessHandler)
                    .failureHandler(authFailureHandler)
                .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/api/user/logout"))
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true) // ???????????? ????????? ?????? ?????????
                    .deleteCookies("JSESSIONID")
                    .permitAll();
//                .and()
//                    .oauth2Login()
//                    .userInfoEndpoint()
//                    .userService(customOAuth2UserService);
//                .and()
//                    .sessionManagement()
//                    .maximumSessions(1)// ?????? ?????? 1
//                    .maxSessionsPreventsLogin(false) // ?????? ????????? ??? ?????? ?????? ??????
//                    .expiredUrl("/loginError");
    }


}
