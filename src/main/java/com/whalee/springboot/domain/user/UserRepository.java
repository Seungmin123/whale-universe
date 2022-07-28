package com.whalee.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // 이메일을 통해 이미 생성된 사용자인지 신규 가입자인지 판단하는 메소드
    Optional<User> findByEmail(String email);
}
