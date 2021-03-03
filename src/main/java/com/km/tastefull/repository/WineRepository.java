package com.km.tastefull.repository;

import com.km.tastefull.domain.Wine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WineRepository extends JpaRepository<Wine, Long> {


    Page<Wine> findByCountry(Pageable pageable, String country);

    Page<Wine> findByGrapes(Pageable pageable, String grapes);
}
