package com.whalee.practice.springboot.web;

import com.whalee.springboot.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = IndexController.class,
    excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE
            , classes = SecurityConfig.class)
    })
// @WebMvcTest 는 CustomOAuth2UserService를 스캔하지 않음. 테스트 오류 생김.
// 대상 @ControllerAdvice, @Controller
// 비대상 @Repository, @Service, @Component
// 스캔 대상에서 SecurityConfig를 지웠음; 언제 삭제될지 모르니 사용안하는걸 추천
public class IndexControllerTest {

    @Autowired
    private MockMvc mvc;

    // 사용자 인증정보 추가
    @WithMockUser(roles="USER")
    @Test
    public void return_index() throws Exception{
        String hello = "nice to meet you. it's index page";

        mvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }
    @WithMockUser(roles="USER")
    @Test
    public void return_indexDto() throws Exception{
        String name = "whalee";
        int amount = 1000;

        mvc.perform(
                get("/index/dto")
                    .param("name", name)
                    .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
