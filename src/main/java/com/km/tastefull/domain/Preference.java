package com.km.tastefull.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Preference {

    private String pref_region1;
    private String pref_region2;
    private String pref_region3;
    private String pref_grape1;
    private String pref_grape2;
    private String pref_grape3;


    public Preference(String pref_region1, String pref_region2, String pref_region3, String pref_grape1, String pref_grape2, String pref_grape3) {
        this.pref_region1 = pref_region1;
        this.pref_region2 = pref_region2;
        this.pref_region3 = pref_region3;
        this.pref_grape1 = pref_grape1;
        this.pref_grape2 = pref_grape2;
        this.pref_grape3 = pref_grape3;
    }
}
