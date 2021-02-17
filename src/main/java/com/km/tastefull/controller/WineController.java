package com.km.tastefull.controller;

import com.km.tastefull.domain.Member;
import com.km.tastefull.domain.Preference;
import com.km.tastefull.domain.Wine;
import com.km.tastefull.dto.MemberDto;
import com.km.tastefull.dto.WineDto;
import com.km.tastefull.service.WineService;
import lombok.RequiredArgsConstructor;
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



}
