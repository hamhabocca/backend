package com.hamhabocca.dallibocca.rally.repository;

import com.hamhabocca.dallibocca.rally.entity.RallyMate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RallyMateRepository extends JpaRepository<RallyMate, Integer> {

    List<RallyMate> findAllByRallyId(int rallyId);

    RallyMate findByRallyIdAndMemberId(int rallyId, int memberId);

    List<RallyMate> findAllByMemberId(int currentMemberId);

    boolean existsByRallyIdAndMemberId(int rallyId, int memberId);
}
