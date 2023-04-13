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

}
