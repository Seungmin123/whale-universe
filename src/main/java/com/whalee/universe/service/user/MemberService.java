package com.whalee.universe.service.user;

import com.whalee.universe.domain.user.Member;
import com.whalee.universe.domain.user.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberRepository.findByName(username);

        if(member == null) throw new IllegalArgumentException("계정이 존재하지 않습니다.");

        return member;
    }

    public Member saveMember(Member member){
        validationDuplicateMember(member);

        return memberRepository.save(member);
    }

    private void validationDuplicateMember(Member member){
        Member findMember = memberRepository.findByName(member.getName());
        if(findMember != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }


}
