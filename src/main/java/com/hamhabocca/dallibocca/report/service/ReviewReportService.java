package com.hamhabocca.dallibocca.report.service;

import com.hamhabocca.dallibocca.report.entity.ReviewReport;
import com.hamhabocca.dallibocca.report.repository.ReviewReportRepository;
import com.hamhabocca.dallibocca.report.dto.ReviewReportDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewReportService {

    private final ReviewReportRepository reviewReportRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ReviewReportService(ReviewReportRepository reviewReportRepository, ModelMapper modelMapper){
        this.reviewReportRepository = reviewReportRepository;
        this.modelMapper = modelMapper;
    }

    /*등록*/
    @Transactional
    public void registNewReviewReport(ReviewReportDTO newReviewReport){
        reviewReportRepository.save(modelMapper.map(newReviewReport, ReviewReport.class));
    }

    /*전체 조회*/
    public List<ReviewReportDTO> findAllReviewReport() {
        List<ReviewReport> reviewReposts = reviewReportRepository.findAllReviewReport();
        return reviewReposts.stream().map(reviewRepost -> modelMapper.map(reviewRepost, ReviewReportDTO.class)).collect(Collectors.toList());
    }
}

