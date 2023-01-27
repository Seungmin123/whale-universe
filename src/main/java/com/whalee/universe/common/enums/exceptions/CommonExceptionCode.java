package com.whalee.universe.common.enums.exceptions;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum CommonExceptionCode implements ErrorCode {

    //server
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러가 발생했습니다."),
    //login
    MEMBER_NAME_DUPLICATION(HttpStatus.IM_USED, "중복된 이름이 존재합니다."),
    MEMBER_NICKNAME_DUPLICATION(HttpStatus.IM_USED, "중복된 닉네임이 존재합니다."),
    MEMBER_LOGIN_FAIL(HttpStatus.NOT_ACCEPTABLE, "로그인에 실패했습니다. 아이디와 비밀번호를 확인해주세요."),
    VALID_FAIL(HttpStatus.BAD_REQUEST, "유효성 검사에 실패했습니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 아이디의 회원을 찾을 수 없습니다.");


    private HttpStatus httpStatus;

    private String message;

    CommonExceptionCode(HttpStatus httpStatus, String message){
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public static CommonExceptionCode getExceptionCodeByMessage(String message){
        return Arrays.stream(CommonExceptionCode.values())
                .filter(c -> message.equals(c.message))
                .findFirst().get();
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}
