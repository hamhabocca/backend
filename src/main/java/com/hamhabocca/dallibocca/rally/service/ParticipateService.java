package com.hamhabocca.dallibocca.rally.service;

import com.hamhabocca.dallibocca.rally.dto.RallyMateDTO;
import com.hamhabocca.dallibocca.rally.entity.RallyMate;
import com.hamhabocca.dallibocca.rally.repository.RallyMateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipateService {

    private final RallyMateRepository rallyMateRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ParticipateService(RallyMateRepository rallyMateRepository, ModelMapper modelMapper) {
        this.rallyMateRepository = rallyMateRepository;
        this.modelMapper = modelMapper;
    }

    /* 현재 랠리의 신청 현황 조회 */
    public List<RallyMateDTO> findRallyMateList(int rallyId) {

        List<RallyMate> rallyMates = rallyMateRepository.findAllByRallyId(rallyId);

        return rallyMates.stream()
            .map(rallyMate -> modelMapper.map(rallyMate, RallyMateDTO.class))
            .collect(Collectors.toList());
    }

    /* 현재 랠리 신청 */
    public void participateByMate(int rallyId, @RequestHeader("memberId") int memberId) {

        RallyMateDTO rallyMate = new RallyMateDTO();

        rallyMate.setRallyId(rallyId);
        rallyMate.setMemberId(memberId);
        rallyMate.setIsAccepted("N");
        rallyMate.setParticipationDate(new Date());

        rallyMateRepository.save(modelMapper.map(rallyMate, RallyMate.class));
    }

    /* 현재 랠리 신청 취소 */
    @Transactional
    public void cancelParticipateByMate(int rallyId, int currentMemberId) {

        RallyMate found = rallyMateRepository.findByRallyIdAndMemberId(rallyId, currentMemberId);

        rallyMateRepository.delete(found);
    }

    /* 현재 랠리 신청 승인 */
    @Transactional
    public void allowParticipate(int rallyId, int memberId) {

        RallyMate foundRallyMate = rallyMateRepository.findByRallyIdAndMemberId(rallyId, memberId);

        foundRallyMate.setIsAccepted("Y");
    }

    /* 본인이 신청한 랠리 신청 기록 */
    public List<RallyMateDTO> findParticipateRallyList(int currentMemberId) {

        List<RallyMate> rallyMates = rallyMateRepository.findAllByMemberId(currentMemberId);

        return rallyMates.stream()
            .map(rallyMate -> modelMapper.map(rallyMate, RallyMateDTO.class)).collect(
                Collectors.toList());
    }

}
