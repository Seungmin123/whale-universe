package com.whalee.universe.common.exception;


import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ExceptionCode {

    //server
    SERVER_ERROR("m00000", "서버 에러가 발생했습니다."),
    //login
    MEMBER_NAME_DUPLICATION("m00001", "중복된 이름이 존재합니다."),
    MEMBER_NICKNAME_DUPLICATION("m00002", "중복된 닉네임이 존재합니다."),
    MEMBER_LOGIN_FAIL("m00003", "로그인에 실패했습니다. 아이디와 비밀번호를 확인해주세요."),
    MEMBER_NOT_FOUND("m00010", "해당 아이디의 회원을 찾을 수 없습니다.");


    private String code;

    private String message;

    ExceptionCode(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getMessageByCode(String code){
        return Arrays.stream(ExceptionCode.values())
                .filter(c -> code.equals(c.message))
                .map(ExceptionCode::getMessage).findFirst().toString();
    }
}
