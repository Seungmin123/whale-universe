package com.whalee.universe.service.user.impl;

import com.whalee.universe.common.enums.exceptions.CommonExceptionCode;
import com.whalee.universe.common.enums.log.MemberLogCode;
import com.whalee.universe.model.member.Member;
import com.whalee.universe.model.member.MemberLog;
import com.whalee.universe.repository.member.MemberLogRepository;
import com.whalee.universe.repository.member.MemberRepository;
import com.whalee.universe.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final MemberRepository memberRepository;
    private final MemberLogRepository memberLogRepository;
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public Member saveMember(Member member) throws Exception {
        this.validateDuplicateRegist(member);
        return memberRepository.save(member);
    }

    @Override
    public void updateMember(Long id, Member member) throws Exception {
        this.validateDuplicateRegist(member);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        Member selectMember = entityManager.find(Member.class, id);
        selectMember.updateChangeInfo(member);
        selectMember.setModifiedDate(LocalDateTime.now());
        memberLogRepository.save(
                MemberLog.builder()
                .member(selectMember)
                .code(MemberLogCode.INFO_UPDATE.getCode())
                .build());

        entityManager.persist(selectMember);
        entityManager.flush();
        entityTransaction.commit();
    }

    @Override
    public void validateDuplicateRegist(Member member) throws IllegalArgumentException {
        Member findMemberByName = memberRepository.findByName(member.getName());
        if(findMemberByName != null){
            throw new IllegalArgumentException(CommonExceptionCode.MEMBER_NAME_DUPLICATION.getMessage());
        }

        Member findMemberByNickName = memberRepository.findByNickName(member.getNickName());
        if(findMemberByNickName != null){
            throw new IllegalArgumentException(CommonExceptionCode.MEMBER_NICKNAME_DUPLICATION.getMessage());
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws IllegalArgumentException {
        Member member = memberRepository.findByName(username);

        //
        if(member == null) throw new IllegalArgumentException(CommonExceptionCode.MEMBER_NOT_FOUND.getMessage());

        return member;
    }
}
