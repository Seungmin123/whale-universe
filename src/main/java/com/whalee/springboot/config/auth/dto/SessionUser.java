package com.whalee.springboot.config.auth.dto;

import com.whalee.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    // User 안쓰고 새로 만드는 이유는 User 클래스를 세션에 저장하려고 할 때 직렬화 구현이 안됐다는 오류나기 때문
    // @OneToMany, @ManyToMany 등 자식 엔티티를 갖는다면 성능 이슈, 부수 효과 확률 높음
    // 그럴바엔 직렬화 기능을 가진 세션 Dto를 하나 추가로 만드는게 나음.
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }

}
