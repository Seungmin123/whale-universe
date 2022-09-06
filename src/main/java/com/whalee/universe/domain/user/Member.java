package com.whalee.universe.domain.user;

import com.whalee.universe.domain.BaseTimeEntity;
import com.whalee.universe.domain.user.dto.MemberFormDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@NoArgsConstructor
@Table(name = "member")
@Entity
public class Member extends BaseTimeEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false, length = 1000)
    private String password;

    @Column(nullable = false)
    private String tell;

    @Column(nullable = false)
    private String email;

    @Column
    private String gender;

    @Builder
    public Member(String name, String nickName, String password, String tell, String email, String gender){
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.tell = tell;
        this.email = email;
        this.gender = gender;
    }

    @Builder
    public Member(String name, String nickName, String password, String tell, String email){
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.tell = tell;
        this.email = email;
    }

    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder){
        Member member = Member.builder()
                .name(memberFormDto.getName())
                .nickName(memberFormDto.getNickName())
                .password(passwordEncoder.encode(memberFormDto.getPassword()))
                .tell(memberFormDto.getTell())
                .email(memberFormDto.getEmail())
                .gender(memberFormDto.getGender())
                .build();

        return member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection < GrantedAuthority > collectors = new ArrayList<>();
        collectors.add(() -> {
            return "게정별 등록할 권한";
        });
        return collectors;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public String getPassword(){
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
