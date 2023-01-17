package com.whalee.universe.model.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "memberLog")
@Entity
public class MemberLog extends Member{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberLogId;

    private String memberLogCode;

    private Long memberId;

    private String name;

    private String nickName;

    private String password;

    @Builder
    public MemberLog(Member member, String code){
        this.memberLogCode = code;
        this.memberId = member.getId();
        this.name = member.getName();
        this.nickName = member.getNickName();
        this.password = member.getPassword();
    }
}
