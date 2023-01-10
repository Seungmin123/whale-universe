package com.whalee.universe.service.member;

import com.whalee.universe.model.member.Member;

public interface MemberService {

    public Member getMemberById(Long id) throws Exception;

    public Member getMemberByName(String name) throws Exception;

    public Member getMemberByNickName(String nickName) throws Exception;

}
