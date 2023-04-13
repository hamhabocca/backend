package com.hamhabocca.dallibocca.report.controller;


import com.hamhabocca.dallibocca.common.ResponseMessage;

import com.hamhabocca.dallibocca.report.reviewReportDto.ReviewReportDTO;
import com.hamhabocca.dallibocca.report.service.ReviewReportService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ReviewReportController {
    private final ReviewReportService reviewReportService;

    @Autowired
    public ReviewReportController(ReviewReportService reviewReportService){
        this.reviewReportService = reviewReportService;
    }

    @ApiOperation(value = "테스트용 리뷰 신고 추가")
    @PostMapping("registreports")
    public ResponseEntity<ResponseMessage> registReviewReportForTesting(@RequestBody ReviewReportDTO newReviewReport){

        reviewReportService.registNewReviewReport(newReviewReport);

        return ResponseEntity
                .created(URI.create("/swagger/reviewreports" + newReviewReport.getReportCode()))
                .build();
    }


    @ApiOperation(value = "리뷰 신고 전체 조회")
    @GetMapping("/reports")
    public ResponseEntity<ResponseMessage> findAllReviewReport() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Map<String, Object> responseMap = new HashMap<>();

        List<ReviewReportDTO> reviewReports = reviewReportService.findAllReviewReport();
        responseMap.put("reports", reviewReports);

        return new ResponseEntity<>(
                new ResponseMessage(200, "조회성공", responseMap),
                headers,
                HttpStatus.OK
        );

    }


}
