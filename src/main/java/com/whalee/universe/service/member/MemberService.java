package com.whalee.universe.service.member;

import com.whalee.universe.domain.member.Member;
import com.whalee.universe.domain.member.dto.MemberFormDto;

public interface MemberService {

    Member saveMember(Member member) throws Exception;

    void validateDuplicateRegist(Member member) throws Exception;

}
