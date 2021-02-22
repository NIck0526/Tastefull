package com.km.tastefull.controller;

import com.km.tastefull.domain.Wine;
import com.km.tastefull.dto.WineDto;
import com.km.tastefull.service.WineService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class WineController {


    private final WineService wineService;



    //와인등록 페이지
    @GetMapping("/wines/new")
    public String createWineForm(Model model) {
        model.addAttribute("wineForm", new WineDto.NewWineForm());
        return "wines/createWineForm";
    }

    @PostMapping("/wines/new")
    public String createWine(@Valid WineDto.NewWineForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "members/createWineForm";
        }

        Wine wine = new Wine(form.getName(), form.getCountry(), form.getRegion(), form.getType(), form.getGrapes(), form.getProducer(), form.getVintage(), form.getAbv());

        wineService.join(wine);
        return "redirect:/";

    }


    //와인 리스트 조회
    @GetMapping("/wines")
    public Page<WineDto.wineList> wineList(@PageableDefault(size = 5) Pageable pageable) {
        Page<Wine> page = wineService.list(pageable);


//        Page<MemberDto> map = page.map(member -> new MemberDto(member.getId(), member.getUsername(), "teamA"));
        Page<WineDto.wineList> map = page.map(w -> new WineDto.wineList(w.getId(),w.getName(),w.getCountry(),w.getRegion(),w.getType(),w.getGrapes(),w.getProducer()));
        return map;
    }





}
