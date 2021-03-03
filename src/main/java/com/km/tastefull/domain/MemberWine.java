package com.km.tastefull.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter /* 메소드 변수로 들어온 memberWine 에 setter 말고 생성자로 넣을 수 있는 방법이...?  addMemberWine */
@Table(name = "member_wine")
@NoArgsConstructor(access = AccessLevel.PROTECTED) /* 엔터티 객체를 생성한 뒤 setter를 독립적으로 생성못하게 막음 (createOrderItem)과 같이 메서드 생성하여 사용*/
public class MemberWine {

    @Id @GeneratedValue
    @Column(name = "member_wine_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wine_id")
    private Wine wine;

    public MemberWine(Wine wine) {
        this.wine = wine;
    }

    public MemberWine(Member member) {
        this.member = member;
    }

    /* 연관관계 편의 메서드 */
    public static MemberWine createMemberWine(Member member) {
        MemberWine memberWine = new MemberWine(member);
        return memberWine;

    }
}
