package com.km.tastefull.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Note {

    @Id
    @GeneratedValue
    @Column(name = "note_id")
    private Long id;

    private String appear_intensity;
    private String color;
    private String nose_intensity;
    private String nose_primary;
    private String nose_secondary;
    private String nose_tertiary;

    @Embedded
    private Palette palette;

    private String quality;
    private String comments;
    private LocalDateTime tasting_date;
    private double prices;
    private String market;


    public Note( String appear_intensity, String color, String nose_intensity, String nose_primary, String nose_secondary, String nose_tertiary, Palette palette, String quality, String comments, LocalDateTime tasting_date, double prices, String market) {
        this.appear_intensity = appear_intensity;
        this.color = color;
        this.nose_intensity = nose_intensity;
        this.nose_primary = nose_primary;
        this.nose_secondary = nose_secondary;
        this.nose_tertiary = nose_tertiary;
        this.palette = palette;
        this.quality = quality;
        this.comments = comments;
        this.tasting_date = tasting_date;
        this.prices = prices;
        this.market = market;
    }
}
