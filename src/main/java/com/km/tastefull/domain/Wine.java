package com.km.tastefull.domain;

import com.km.tastefull.dto.WineDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Wine {

    @Id
    @GeneratedValue
    @Column(name = "wine_id")
    private Long id;

    private String name;
    private String country;
    private String region;
    private String type;
    private String grapes;
    private String blendingYn;
    private String producer;
    private int vintage;
    private double abv; // 도수

    @OneToMany(mappedBy = "wine", cascade = CascadeType.ALL) //cascade
    private List<MemberWine> memberWines = new ArrayList<>();

    public Wine(String name, String country, String region, String type, String grapes, String blendingYn, String producer, int vintage, double abv) {
        this.name = name;
        this.country = country;
        this.region = region;
        this.type = type;
        this.grapes = grapes;
        this.blendingYn = blendingYn;
        this.producer = producer;
        this.vintage = vintage;
        this.abv = abv;
    }

    public Wine(List<MemberWine> memberWines) {
        this.memberWines = memberWines;
    }




    /* 연관관계 메서드 */
    public void addMemberWine(MemberWine memberWine) {
        memberWines.add(memberWine);
        memberWine.setWine(this);
    }

    /* 생성메서드 */
    public static Wine createWine(MemberWine memberWine, WineDto form) {

        Wine wine = new Wine(form.getName(), form.getCountry(), form.getRegion(), form.getType(), form.getGrapes(), form.getBlendingYn(),form.getProducer(), form.getVintage(), form.getAbv());

        wine.addMemberWine(memberWine);

        return wine;

    }
}
