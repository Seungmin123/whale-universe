package com.whalee.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//JpaRepository<Entity 클래스, PK 타입>를 상속 시 기본적인 CRUD 메소드가 자동으로 생성됨.
public interface PostsRepository extends JpaRepository<Posts, Long> {
    
    // SpringDataJpa에서 제공하지 않는 메소드는 이처럼 쿼리로 작성해도됨.
    // 앞의 내용은 SpringDataJpa 기본 메소드로 해결 가능
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

    // 규모있는 프로젝트에서는 조회용 프레임워크를 사용함
    // querydsl 같은거
    // 타입 안정성이 보장됨.
    // 국내 많은 회사에서 사용 중.
    // 레퍼런스가 많음.

}
