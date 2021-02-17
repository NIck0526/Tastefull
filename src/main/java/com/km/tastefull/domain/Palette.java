package com.km.tastefull.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Palette {

    private String pal_sweetness;
    private String pal_acidity;
    private String pal_tannin;
    private String pal_alcohol;
    private String pal_body;
    private String pal_primary;
    private String pal_flavour;
    private String pal_secondary;
    private String pal_tertiary;
    private String pal_finish;


    public Palette(String pal_sweetness, String pal_acidity, String pal_tannin, String pal_alcohol, String pal_body, String pal_primary, String pal_flavour, String pal_secondary, String pal_tertiary, String pal_finish) {
        this.pal_sweetness = pal_sweetness;
        this.pal_acidity = pal_acidity;
        this.pal_tannin = pal_tannin;
        this.pal_alcohol = pal_alcohol;
        this.pal_body = pal_body;
        this.pal_primary = pal_primary;
        this.pal_flavour = pal_flavour;
        this.pal_secondary = pal_secondary;
        this.pal_tertiary = pal_tertiary;
        this.pal_finish = pal_finish;
    }
}
