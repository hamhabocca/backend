package com.hamhabocca.dallibocca.report.controller;


import com.hamhabocca.dallibocca.qna.dto.QnaDTO;
import com.hamhabocca.dallibocca.report.dto.RallyReportDTO;
import com.hamhabocca.dallibocca.report.entity.RallyReport;
import com.hamhabocca.dallibocca.report.service.RallyReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Api(tags = "RallyReport API")
@RestController
@RequestMapping("/api/v1/")
public class RallyReportController {

	private final RallyReportService rallyReportService;

	@Autowired
	public RallyReportController(RallyReportService rallyReportService) {
		this.rallyReportService = rallyReportService;
	}

	@ApiOperation(value = "신고글 추가")
	@PostMapping("/reports")
	public ResponseEntity<?> registNewRallyReport(@RequestBody RallyReportDTO newRallyReport) {

		rallyReportService.registNewRallyReport(newRallyReport);

		return ResponseEntity
			.created(URI.create("/swagger/reports" + newRallyReport.getReportId()))
			.build();
	}

	@ApiOperation(value = "신고 승낙/거절")
	@PutMapping("/reports/{reportId}")
	public ResponseEntity<?> modifyRallyReport(@PathVariable int reportId, String type) {

		rallyReportService.modifyRallyReport(reportId, type);

		return ResponseEntity
			.created(URI.create("/swagger/reports" + reportId))
			.build();
	}


}



