package com.km.tastefull.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    private String producer;
    private int vintage;
    private double abv; // 도수

    public Wine(String name, String country, String region, String type, String grapes, String producer, int vintage, double abv) {
        this.name = name;
        this.country = country;
        this.region = region;
        this.type = type;
        this.grapes = grapes;
        this.producer = producer;
        this.vintage = vintage;
        this.abv = abv;
    }
}
