package com.hamhabocca.dallibocca.report.repository;

import com.hamhabocca.dallibocca.report.entity.ReviewReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewReportRepository extends JpaRepository<ReviewReport, Integer> {

    /*리뷰 신고 리스트 전체 호츌*/
    @Query(value = "SELECT A.REPORT_CODE, A.REPORT_WRITER, A.REPORT_TARGET, A.REPORT_DATE, A.REPORT_REASON, A.REPORT_REASON_DETAIL, A.IS_PROCESSED FROM REVIEW_REPORT A ORDER BY A.REPORT_CODE ASC", nativeQuery = true)
    List<ReviewReport> findAllReviewReport();
}
