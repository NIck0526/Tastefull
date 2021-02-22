package com.km.tastefull.dto;

import com.km.tastefull.domain.Wine;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class WineDto {




    @Getter
    @NoArgsConstructor
    public static class NewWineForm{
        private String name;
        private String country;
        private String region;
        private String type;
        private String grapes;
        private String producer;
        private int vintage;
        private double abv;

        @Builder
        public NewWineForm(String name, String country, String region, String type, String grapes, String producer, int vintage, double abv) {
            this.name = name;
            this.country = country;
            this.region = region;
            this.type = type;
            this.grapes = grapes;
            this.producer = producer;
            this.vintage = vintage;
            this.abv = abv;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class wineList{
        private Long id;
        private String name;
        private String country;
        private String region;
        private String type;
        private String grapes;
        private String producer;

        public wineList(Long id, String name, String country, String region, String type, String grapes, String producer) {
            this.id = id;
            this.name = name;
            this.country = country;
            this.region = region;
            this.type = type;
            this.grapes = grapes;
            this.producer = producer;
        }


    }



}
