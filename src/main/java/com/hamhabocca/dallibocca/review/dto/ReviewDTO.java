package com.hamhabocca.dallibocca.review.dto;

import java.util.Date;

public class ReviewDTO {

    private Long reviewId;

    private String reviewTitle;

    private String reviewWriter;

    private String reviewDetail;

    private Long rallyId;

    private Date reviewWriteDate;
    public ReviewDTO() {}

    public ReviewDTO(Long reviewId, String reviewTitle, String reviewWriter, String reviewDetail,
        Long rallyId, Date reviewWriteDate) {
        this.reviewId = reviewId;
        this.reviewTitle = reviewTitle;
        this.reviewWriter = reviewWriter;
        this.reviewDetail = reviewDetail;
        this.rallyId = rallyId;
        this.reviewWriteDate = reviewWriteDate;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewWriter() {
        return reviewWriter;
    }

    public void setReviewWriter(String reviewWriter) {
        this.reviewWriter = reviewWriter;
    }

    public String getReviewDetail() {
        return reviewDetail;
    }

    public void setReviewDetail(String reviewDetail) {
        this.reviewDetail = reviewDetail;
    }

    public Long getRallyId() {
        return rallyId;
    }

    public void setRallyId(Long rallyId) {
        this.rallyId = rallyId;
    }

    public Date getReviewWriteDate() {
        return reviewWriteDate;
    }

    public void setReviewWriteDate(Date reviewWriteDate) {
        this.reviewWriteDate = reviewWriteDate;
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
            "reviewId=" + reviewId +
            ", reviewTitle='" + reviewTitle + '\'' +
            ", reviewWriter='" + reviewWriter + '\'' +
            ", reviewDetail='" + reviewDetail + '\'' +
            ", rallyId=" + rallyId +
            ", reviewWriteDate=" + reviewWriteDate +
            '}';
    }
}
