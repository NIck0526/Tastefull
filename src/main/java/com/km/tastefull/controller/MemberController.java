package com.km.tastefull.controller;

import com.km.tastefull.domain.Member;
import com.km.tastefull.domain.Preference;
import com.km.tastefull.dto.MemberDto;
import com.km.tastefull.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {


    private final MemberService memberService;


    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberDto.JoinForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberDto.JoinForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "members/createMemberForm";
        }

        Preference preference = new Preference(form.getPref_region1(),
                form.getPref_region2(),
                form.getPref_region3(),
                form.getPref_grape1(),
                form.getPref_grape2(),
                form.getPref_grape3());


        Member member = new Member(form.getEmail(), form.getAge(), form.getGender(), form.getCountry(), preference);


        memberService.join(member);
        return "redirect:/";

    }


}
