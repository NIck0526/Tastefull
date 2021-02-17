package com.km.tastefull.controller;

import com.km.tastefull.domain.Note;
import com.km.tastefull.domain.Palette;
import com.km.tastefull.domain.Wine;
import com.km.tastefull.dto.NoteDto;
import com.km.tastefull.dto.WineDto;
import com.km.tastefull.service.NoteService;
import com.km.tastefull.service.WineService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class NoteController {


    private final NoteService noteService;

    //와인등록 페이지
    @GetMapping("/wines/{id}/note/new")
    public String createWineForm(Model model, @PathVariable("id") Long id) {

        //노트 dto에  id 추가하여 반환
        NoteDto note = new NoteDto(id);
        
        model.addAttribute("noteForm", note);
        return "notes/createNoteForm";
    }

    //추가되어 반환한 id를 그대로 사용
    @PostMapping("/wines/{id}/note/new")
    public String createWine(@Valid NoteDto.NewNoteForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "notes/createNoteForm";
        }

        Palette palette = new Palette(
                    form.getPal_sweetness(),
                    form.getPal_acidity(),
                    form.getPal_tannin(),
                    form.getPal_alcohol(),
                    form.getPal_body(),
                    form.getPal_flavour(),
                    form.getPal_primary(),
                    form.getPal_secondary(),
                    form.getPal_tertiary(),
                    form.getPal_finish());

        Note note = new Note(
                form.getAppear_intensity(),
                form.getColor(),
                form.getNose_intensity(),
                form.getNose_primary(),
                form.getNose_secondary(),
                form.getNose_tertiary(),
                palette,
                form.getQuality(),
                form.getComments(),
                form.getTasting_date(),
                form.getPrices(),
                form.getMarket());

        noteService.join(note);
        return "redirect:/";

    }



}
