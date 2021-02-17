package com.km.tastefull.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class NoteDto {

    private Long id;

    public NoteDto(Long id) {
        this.id = id;
    }

    @Getter
    @NoArgsConstructor
    public static class NewNoteForm{

        private String appear_intensity;
        private String color;
        private String nose_intensity;
        private String nose_primary;
        private String nose_secondary;
        private String nose_tertiary;

        private String pal_sweetness;
        private String pal_acidity;
        private String pal_tannin;
        private String pal_alcohol;
        private String pal_body;
        private String pal_flavour;
        private String pal_primary;
        private String pal_secondary;
        private String pal_tertiary;
        private String pal_finish;

        private String quality;
        private String comments;
        private LocalDateTime tasting_date;
        private double prices;
        private String market;

        @Builder
        public NewNoteForm(String appear_intensity, String color, String nose_intensity, String nose_primary,String nose_secondary, String nose_tertiary, String pal_sweetness, String pal_acidity, String pal_tannin, String pal_alcohol, String pal_body, String pal_flavour, String pal_primary, String pal_secondary, String pal_tertiary, String pal_finish, String quality, String comments, LocalDateTime tasting_date, double prices, String market) {
            this.appear_intensity = appear_intensity;
            this.color = color;
            this.nose_intensity = nose_intensity;
            this.nose_primary = nose_primary;
            this.nose_secondary = nose_secondary;
            this.nose_tertiary = nose_tertiary;
            this.pal_sweetness = pal_sweetness;
            this.pal_acidity = pal_acidity;
            this.pal_tannin = pal_tannin;
            this.pal_alcohol = pal_alcohol;
            this.pal_body = pal_body;
            this.pal_flavour = pal_flavour;
            this.pal_primary = pal_primary;
            this.pal_secondary = pal_secondary;
            this.pal_tertiary = pal_tertiary;
            this.pal_finish = pal_finish;
            this.quality = quality;
            this.comments = comments;
            this.tasting_date = tasting_date;
            this.prices = prices;
            this.market = market;
        }
    }

}
