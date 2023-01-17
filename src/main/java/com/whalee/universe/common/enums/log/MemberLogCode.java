package com.whalee.universe.common.enums.log;


import lombok.Getter;

import java.util.Arrays;

@Getter
public enum MemberLogCode {

    //regist
    REGIST("REGIST", "회원가입"),
    INFO_UPDATE("INFO_UPDATE", "회원정보 변경");


    private String code;

    private String message;

    MemberLogCode(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getMessageByCode(String code){
        return Arrays.stream(MemberLogCode.values())
                .filter(c -> code.equals(c.message))
                .map(MemberLogCode::getMessage).findFirst().toString();
    }
}
