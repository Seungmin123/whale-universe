package com.whalee.universe.domain.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자"),
    ADMIN("ROLE_ADMIN", "일반 관리자"),
    ENGINEER("ROLE_ENGINEER", "수퍼 관리자");

    private final String key;
    private final String title;
}
