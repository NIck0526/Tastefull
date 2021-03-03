package com.km.tastefull.controller;

import com.km.tastefull.domain.Member;
import com.km.tastefull.domain.Preference;
import com.km.tastefull.domain.Wine;
import com.km.tastefull.dto.MemberDto;
import com.km.tastefull.dto.WineDto;
import com.km.tastefull.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {


    private final MemberService memberService;


    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberDto());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberDto form, BindingResult result) {

        if (result.hasErrors()) {
            return "members/createMemberForm";
        }


        Preference preference = new Preference(
                form.getPref_region1(),
                form.getPref_region2(),
                form.getPref_region3(),
                form.getPref_grape1(),
                form.getPref_grape2(),
                form.getPref_grape3());


        Member member = new Member(form.getEmail(), form.getAge(), form.getGender(), form.getCountry(), preference);


        memberService.join(member);
        return "redirect:/";

    }

    @GetMapping("/members")
    public String findMembers(Model model, @PageableDefault(size = 5) Pageable pageable) {
        Page<Member> page = memberService.findMembers(pageable);
        System.out.println("first");
        System.out.println(page.getContent().get(0).getEmail());


//        Page<MemberDto> map = page.map(m -> new MemberDto(m.getEmail(), m.getAge(), m.getGender(), m.getCountry(), m.getPreference()));
        Page<MemberDto> map = page.map(MemberDto::new);

        System.out.println("dddddddddd");
        System.out.println(map.getContent().get(0).getEmail());

        model.addAttribute("members", map);

        return "members/memberList";
    }



}
