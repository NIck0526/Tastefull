package com.km.tastefull.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    private String email;
    private int age;
    private String gender;
    private String country;

    @Embedded
    private Preference preference;

    public Member(@NotEmpty String email, int age, String gender, String country, Preference preference) {
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.country = country;
        this.preference = preference;
    }
}
