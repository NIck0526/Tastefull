package com.km.tastefull.service;

import com.km.tastefull.domain.Member;
import com.km.tastefull.domain.Wine;
import com.km.tastefull.repository.MemberRepository;
import com.km.tastefull.repository.WineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WineService {

    private final WineRepository wineRepository;

    public Long join(Wine wine) {
        wineRepository.save(wine);
        return wine.getId();
    }


}
