package com.whalee.universe.service.member.impl;

import com.whalee.universe.model.member.Member;
import com.whalee.universe.repository.member.MemberRepository;
import com.whalee.universe.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member getMemberById(Long id) throws Exception {
        return memberRepository.findById(id).get();
    }

    @Override
    public Member getMemberByName(String name) throws Exception {
        return memberRepository.findByName(name);
    }

    @Override
    public Member getMemberByNickName(String nickName) throws Exception {
        return memberRepository.findByNickName(nickName);
    }
}
