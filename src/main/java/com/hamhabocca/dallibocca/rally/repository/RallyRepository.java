package com.hamhabocca.dallibocca.rally.repository;

import com.hamhabocca.dallibocca.rally.dto.RallySimpleDTO;
import com.hamhabocca.dallibocca.rally.entity.Rally;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RallyRepository extends JpaRepository<Rally, Integer> {

    @Query("SELECT new com.hamhabocca.dallibocca.rally.dto.RallySimpleDTO(r.rallyId,r.rallyStatus,r.rallyName,r.rallyDate,r.rallyStartLocation,r.rallyWriteDate) FROM Rally r")
    Page<RallySimpleDTO> findSimpleRallyList(Pageable pageable);

}
