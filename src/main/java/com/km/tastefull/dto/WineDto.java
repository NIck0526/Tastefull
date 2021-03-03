package com.km.tastefull.dto;

import com.km.tastefull.domain.Wine;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WineDto {

    private Long id;
    private String name;
    private String country;
    private String region;
    private String type;
    private String grapes;
    private String blendingYn;
    private String producer;
    private int vintage;
    private double abv;



    public WineDto(Long id, String name, String country, String region, String type, String grapes, String blendingYn, String producer) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.region = region;
        this.type = type;
        this.grapes = grapes;
        this.blendingYn = blendingYn;
        this.producer = producer;
    }
}
