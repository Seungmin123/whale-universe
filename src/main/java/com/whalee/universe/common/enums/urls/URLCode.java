package com.whalee.universe.common.enums.urls;


import lombok.Getter;

import java.util.Arrays;

@Getter
public enum URLCode {

    //login
    URL_ROOT("/"),
    MEMBER_LOGIN("/index"),
    MEMBER_REGIST("/user/register"),
    MEMBER_DETAIL("/member/detail");


    private String url;


    URLCode(String url){
        this.url = url;
    }
}
