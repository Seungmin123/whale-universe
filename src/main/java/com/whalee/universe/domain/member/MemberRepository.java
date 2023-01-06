package com.whalee.universe.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    public Member findByName(String name);

    public Member findByNickName(String name);
}
