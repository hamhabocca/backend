package com.hamhabocca.dallibocca.report.service;

import com.hamhabocca.dallibocca.report.dto.RallyReportDTO;
import com.hamhabocca.dallibocca.report.entity.RallyReport;
import com.hamhabocca.dallibocca.report.repository.RallyReportRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RallyReportService {

	private final RallyReportRepository rallyReportRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public RallyReportService(RallyReportRepository rallyReportRepository,
		ModelMapper modelMapper) {
		this.rallyReportRepository = rallyReportRepository;
		this.modelMapper = new ModelMapper();
	}

	@Transactional
	public void registNewRallyReport(RallyReportDTO newRallyReport) {

		rallyReportRepository.save(modelMapper.map(newRallyReport, RallyReport.class));
	}

	@Transactional
	public void modifyRallyReport(long reportId, String type) {

		RallyReport foundRallyReport = rallyReportRepository.findById(reportId)
			.get();

		switch (type) {
			case "OK":
				foundRallyReport.setIsProcessed("Y");
				break;
			case "Reject":
				foundRallyReport.setIsProcessed("N");
				break;
		}

	}

	/*랠리 신고 전체 조회*/
	public List<RallyReportDTO> findAllRallyReports() {
		List<RallyReport> rallyReports = rallyReportRepository.findAll();
		return rallyReports.stream()
			.map(rallyReport -> modelMapper.map(rallyReport, RallyReportDTO.class))
			.collect(Collectors.toList());
	}
}
