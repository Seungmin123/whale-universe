package com.whalee.universe.repository.member;

import com.whalee.universe.model.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT m FROM Member m WHERE m.name = :name")
    public Member findByName(@Param("name") String name);

    @Query("SELECT m FROM Member m WHERE m.nickName = :nickName")
    public Member findByNickName(@Param("nickName") String nickName);

}
