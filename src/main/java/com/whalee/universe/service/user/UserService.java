package com.whalee.universe.service.user;

import com.whalee.universe.model.member.Member;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    Member saveMember(Member member) throws Exception;

    Member updateMember(Member member) throws Exception;

    void validateDuplicateRegist(Member member) throws Exception;

}
