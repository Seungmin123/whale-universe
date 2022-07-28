package com.whalee.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<Entity 클래스, PK 타입>를 상속 시 기본적인 CRUD 메소드가 자동으로 생성됨.
public interface PostsRepository extends JpaRepository<Posts, Long> {


}
