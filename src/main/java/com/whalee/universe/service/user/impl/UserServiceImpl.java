package com.whalee.universe.service.user.impl;

import com.whalee.universe.common.exception.ExceptionCode;
import com.whalee.universe.domain.member.Member;
import com.whalee.universe.domain.member.MemberRepository;
import com.whalee.universe.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final MemberRepository memberRepository;

    @Override
    public Member saveMember(Member member) throws Exception {
        this.validateDuplicateRegist(member);
        return memberRepository.save(member);
    }

    @Override
    public void validateDuplicateRegist(Member member) throws IllegalArgumentException {
        Member findMemberByName = memberRepository.findByName(member.getName());
        if(findMemberByName != null){
            throw new IllegalArgumentException(ExceptionCode.MEMBER_NAME_DUPLICATION.getCode());
        }

        Member findMemberByNickName = memberRepository.findByNickName(member.getNickName());
        if(findMemberByNickName != null){
            throw new IllegalArgumentException(ExceptionCode.MEMBER_NICKNAME_DUPLICATION.getCode());
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByName(username);

        if(member == null) throw new IllegalArgumentException(ExceptionCode.MEMBER_NOT_FOUND.getCode());

        return member;
    }
}
