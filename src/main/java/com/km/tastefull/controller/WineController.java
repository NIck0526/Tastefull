package com.km.tastefull.controller;

import com.km.tastefull.domain.Wine;
import com.km.tastefull.dto.WineDto;
import com.km.tastefull.service.MemberService;
import com.km.tastefull.service.NoteService;
import com.km.tastefull.service.WineService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class WineController {


    private final WineService wineService;
    private final MemberService memberService;
    private final NoteService noteService;


    //와인등록 페이지
    @GetMapping("/wines/new")
    public String createWineForm(Model model) {
        model.addAttribute("wineForm", new WineDto());
        return "wines/createWineForm";
    }

    @PostMapping("/wines/new")
    public String createWine(@Valid WineDto form, BindingResult result) {

        if (result.hasErrors()) {
            return "members/createWineForm";
        }

        //회원세션 가정
        String memberEmail = "nick@gmail.com";
        Long memberId = 1L;


        wineService.join(form, memberId);
        return "redirect:/";

    }


    /*와인 리스트 조회*/
    //전체
    @GetMapping("/wines")
    public Page<WineDto> wineList(@PageableDefault(size = 5) Pageable pageable) {
        Page<Wine> page = wineService.list(pageable);


//        Page<MemberDto> map = page.map(member -> new MemberDto(member.getId(), member.getUsername(), "teamA"));
        Page<WineDto> map = page.map(w -> new WineDto(w.getId(), w.getName(), w.getCountry(), w.getRegion(), w.getType(), w.getGrapes(), w.getBlendingYn(), w.getProducer()));
        return map;
    }

    //나라별
    @GetMapping("/wines/{country}")
    public Page<WineDto> wineListByCountry(@PageableDefault(size = 5) Pageable pageable, @PathVariable("country") String country) {
        Page<Wine> page = wineService.listByCountry(pageable, country);


//        Page<MemberDto> map = page.map(member -> new MemberDto(member.getId(), member.getUsername(), "teamA"));
        Page<WineDto> map = page.map(w -> new WineDto(w.getId(), w.getName(), w.getCountry(), w.getRegion(), w.getType(), w.getGrapes(), w.getBlendingYn(), w.getProducer()));
        return map;
    }

    //품종
    @GetMapping("/wines/{grapes}")
    public Page<WineDto> wineListByGrapes(@PageableDefault(size = 5) Pageable pageable, @PathVariable("grapes") String grapes) {
        Page<Wine> page = wineService.listByGrapes(pageable, grapes);


//        Page<MemberDto> map = page.map(member -> new MemberDto(member.getId(), member.getUsername(), "teamA"));
        Page<WineDto> map = page.map(w -> new WineDto(w.getId(), w.getName(), w.getCountry(), w.getRegion(), w.getType(), w.getGrapes(), w.getBlendingYn(),  w.getProducer()));
        return map;
    }


}
