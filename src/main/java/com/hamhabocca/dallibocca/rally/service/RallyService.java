package com.hamhabocca.dallibocca.rally.service;

import com.hamhabocca.dallibocca.rally.dto.RallyDTO;
import com.hamhabocca.dallibocca.rally.dto.RallySimpleDTO;
import com.hamhabocca.dallibocca.rally.entity.Rally;
import com.hamhabocca.dallibocca.rally.repository.RallyRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RallyService {

    private final RallyRepository rallyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RallyService(RallyRepository rallyRepository, ModelMapper modelMapper) {
        this.rallyRepository = rallyRepository;
        this.modelMapper = modelMapper;
    }

    /* 모든 랠리 목록 조회 */
    public Page<RallySimpleDTO> findRallyList(Pageable pageable) {

        //offset, limit, sort 순서
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
            pageable.getPageSize(),
            Sort.by("rallyId"));

        return rallyRepository.findSimpleRallyList(pageable);
    }

    /* 랠리글 상세 조회 */
    public RallyDTO findRallyById(int rallyId) {

        Rally foundRally = rallyRepository.findById(rallyId).get();

        return modelMapper.map(foundRally, RallyDTO.class);
    }

    /* 랠리글 추가 */
    @Transactional
    public int postNewRally(RallyDTO newRally) {

        /* 기본값 설정 */
        newRally.setRallyStatus("모집중");

        if (newRally.getRallyMinimum() == 0) {
            newRally.setRallyMinimum(2);
        }

        if (newRally.getRallyMaximum() == 0) {
            newRally.setRallyMaximum(5);
        }

        return rallyRepository.save(modelMapper.map(newRally, Rally.class)).getRallyId();
    }

    /* 랠리글 수정 */
    @Transactional
    public void modifyRally(RallyDTO modifyRally, int rallyId) {

        /* 변경할 기존 랠리 가져오기 */
        Rally foundRally = rallyRepository.findById(rallyId).get();

        /* (글조회에서) 랠리상태만 변경 혹은 (글수정화면에서) 랠리 정보 변경 */
        if (!(foundRally.getRallyStatus().equals(modifyRally.getRallyStatus()))) {
            foundRally.setRallyStatus(modifyRally.getRallyStatus());
        } else {
            foundRally.setRallyName(modifyRally.getRallyName());
            foundRally.setRallyDetail(modifyRally.getRallyDetail());
            foundRally.setRallyStartLocation(modifyRally.getRallyStartLocation());
            foundRally.setRallyEndLocation(modifyRally.getRallyEndLocation());
            foundRally.setRallyType(modifyRally.getRallyType());
            foundRally.setRallyMaximum(modifyRally.getRallyMaximum());
            foundRally.setRallyMinimum(modifyRally.getRallyMinimum());
            foundRally.setRallyDistance(modifyRally.getRallyDistance());
            foundRally.setRallyDate(modifyRally.getRallyDate());
        }
    }

}
