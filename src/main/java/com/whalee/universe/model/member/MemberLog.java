package com.whalee.universe.model.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "memberLog")
@Entity
public class MemberLog{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberLogId;

    @Column(nullable = false)
    private String memberLogCode;

    @Column(nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
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
