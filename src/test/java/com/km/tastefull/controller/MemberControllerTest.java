package com.km.tastefull.controller;

import com.km.tastefull.domain.Member;
import com.km.tastefull.domain.Preference;
import com.km.tastefull.dto.MemberDto;
import com.km.tastefull.repository.MemberRepository;
import com.km.tastefull.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(false)
class MemberControllerTest {
    
    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception{

        //given
        MemberDto joinForm = new MemberDto();
                joinForm.setAge(23);
                joinForm.setEmail("test@gmail.com");
                joinForm.setCountry("France");
                joinForm.setGender("Male");
                joinForm.setPref_grape1("Pinot noir");
                joinForm.setPref_grape2("Shiraz");
                joinForm.setPref_grape3("Sangiovese");
                joinForm.setPref_region1("Chianti Classico");
                joinForm.setPref_region2("Cote du Rhone");
        Preference preference = new Preference(joinForm.getPref_region1(), joinForm.getPref_region2(), joinForm.getPref_region3(),
                joinForm.getPref_grape1(), joinForm.getPref_grape2(), joinForm.getPref_grape3());

        System.out.println("joint form "+joinForm.getEmail());
        Member member = new Member(joinForm.getEmail(), joinForm.getAge(), joinForm.getGender(), joinForm.getCountry(),preference);

        //when
        Long memberId = memberService.join(member);
        Optional<Member> findMember = memberRepository.findById(memberId);

        System.out.println("ddd  " +member.getEmail());
        System.out.println("findMember = " + findMember.get().getEmail());

        //then
        assertThat(findMember.get().getId()).isEqualTo(member.getId());
    }


}