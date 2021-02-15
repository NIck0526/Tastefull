package com.km.tastefull.service;

import com.km.tastefull.domain.Wine;
import com.km.tastefull.repository.MemberRepository;
import com.km.tastefull.repository.WineRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class WineServiceTest {

    @Autowired
    WineRepository wineRepository;

    @Test
    void join() {

        //given
        Wine wine = new Wine("Calera", "United States", "Central Coast", "Red", "Pinot Noir", "Calera", 2017, 14.5);

        System.out.println("wine.getName() = " + wine.getName());

        //when
        Wine savedWine = wineRepository.save(wine);
        Optional<Wine> findWine = wineRepository.findById(savedWine.getId());

        //then
        assertThat(findWine.get().getCountry()).isEqualTo(savedWine.getCountry());


    }
}