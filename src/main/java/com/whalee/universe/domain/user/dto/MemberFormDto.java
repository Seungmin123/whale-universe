package com.whalee.universe.domain.user.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class MemberFormDto{

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    @Pattern(regexp="[a-zA-Z가-힣]{1,20}",
            message = "이름은 한글, 영문 대, 소문자로만 이루어진 20자 이하의 문자여야 합니다.")
    private String name;

    @NotBlank(message = "별명은 필수 입력 값입니다.")
    @Pattern(regexp="[a-z].{1,30}",
            message = "별명은 영문 소문자로만 이루어진 30자 이하의 문자여야 합니다.")
    private String nickName;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{10,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 10자 ~ 20자의 문자여야 합니다.")
    private String password;

    @NotBlank(message = "전화번호는 필수 입력 값입니다.")
    @Pattern(regexp="[0-9].{1,20}",
            message = "전화번호는 숫자로만 이루어진 20자 이하의 문자여야 합니다.")
    private String tell;

    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Length(max = 100, message = "100자 이하로 입력해주세요.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;

    private String gender;

    @Builder
    public MemberFormDto(String name, String nickName, String password, String tell, String email, String gender){
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.tell = tell;
        this.email = email;
        this.gender = gender;
    }

    @Builder
    public MemberFormDto(String name, String nickName, String password, String tell, String email){
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.tell = tell;
        this.email = email;
    }

}
