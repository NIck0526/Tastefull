package com.km.tastefull.dto;

import com.km.tastefull.domain.Member;
import lombok.*;

public class MemberDto {




    @Getter
    @NoArgsConstructor
    public static class JoinForm{
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

        @Builder
        public JoinForm(Long id, String email, int age, String gender, String country, String pref_region1, String pref_region2, String pref_region3, String pref_grape1, String pref_grape2, String pref_grape3) {
            this.id = id;
            this.email = email;
            this.age = age;
            this.gender = gender;
            this.country = country;
            this.pref_region1 = pref_region1;
            this.pref_region2 = pref_region2;
            this.pref_region3 = pref_region3;
            this.pref_grape1 = pref_grape1;
            this.pref_grape2 = pref_grape2;
            this.pref_grape3 = pref_grape3;
        }
    }



//    public MemberDto(Member member) {
//        this.id = member.getId();
//        this.email = member.getEmail();
//        this.age = member.getAge();
//        this.gender = member.getGender();
//        this.country = member.getCountry();
//        this.pref_region1 = member.getPref_region1();
//        this.pref_region2 = member.getPref_region2();
//        this.pref_region3 = member.getPref_region3();
//        this.pref_grape1 = member.getPref_grape1();
//        this.pref_grape2 = member.getPref_grape2();
//        this.pref_grape3 = member.getPref_region3();
//    }
}
