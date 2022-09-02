package com.whalee.universe.domain.order;

import com.htbeyond.pretask.domain.BaseTimeEntity;
import com.htbeyond.pretask.domain.user.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Random;

@Getter
@NoArgsConstructor
@Entity
public class Orders extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 12, unique = true)
    private String orderNum;

    @Column(nullable = false, length = 100)
    private String itemName;

    @OneToOne
    @JoinColumn(name="memberId")
    private Member member;

    private String name;

    @Builder
    public Orders(String orderNum, String itemName, Member member){
        this.orderNum = makeKey();
        this.itemName = itemName;
        this.member = member;
    }

    public Orders toEntity(){
        return Orders.builder()
                .orderNum(makeKey())
                .itemName(itemName)
                .member(member)
                .build();
    }

    private String makeKey(){
        Random rnd=new Random();
        StringBuffer buf=new StringBuffer();
        for(int i=0;i<26;i++) {
            if(rnd.nextBoolean())
                buf.append((char)(rnd.nextInt(26)+65));
            else
                buf.append(rnd.nextInt(10));
        }
        return buf.toString();
    }

}
