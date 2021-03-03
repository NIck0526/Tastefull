package com.km.tastefull.dto;

import com.km.tastefull.domain.Member;
import com.km.tastefull.domain.Preference;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {


    private Long id;
    private String email;
    private int age;
    private String gender;
    private String country;
    private String pref_region1;
    private String pref_region2;
    private String pref_region3;
    private String pref_grape1;
    private String pref_grape2;
    private String pref_grape3;





    public MemberDto(Member member) {
        this.email = member.getEmail();
        this.age = member.getAge();
        this.gender = member.getGender();
        this.country = member.getCountry();
        this.pref_region1 = member.getPreference().getPref_region1();
        this.pref_region2 = member.getPreference().getPref_region2();
        this.pref_region3 = member.getPreference().getPref_region3();
        this.pref_grape1 = member.getPreference().getPref_grape1();
        this.pref_grape2 = member.getPreference().getPref_grape2();
        this.pref_grape3 = member.getPreference().getPref_grape3();
    }
}
