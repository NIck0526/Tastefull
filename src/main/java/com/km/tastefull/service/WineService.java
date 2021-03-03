package com.km.tastefull.service;

import com.km.tastefull.domain.Member;
import com.km.tastefull.domain.MemberWine;
import com.km.tastefull.domain.Wine;
import com.km.tastefull.dto.WineDto;
import com.km.tastefull.repository.MemberRepository;
import com.km.tastefull.repository.WineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WineService {

    private final WineRepository wineRepository;
    private final MemberRepository memberRepository;

    public Long join(WineDto form, Long memberId) {



        Optional<Member> member = memberRepository.findById(memberId);



        MemberWine memberWine = MemberWine.createMemberWine(member.get());



        Wine wine = Wine.createWine(memberWine, form);


        wineRepository.save(wine);
        return wine.getId();
    }

    public Page<Wine> list(Pageable pageable){

        return wineRepository.findAll(pageable);

    }

    public Page<Wine> listByCountry(Pageable pageable, String country) {
        return wineRepository.findByCountry(pageable, country);
    }

    public Page<Wine> listByGrapes(Pageable pageable, String grapes) {

        return wineRepository.findByGrapes(pageable, grapes);

    }
}
