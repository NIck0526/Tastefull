package com.km.tastefull.domain;

import javax.persistence.*;

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

}
