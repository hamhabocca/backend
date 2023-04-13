package com.hamhabocca.dallibocca.review.reviewdto;

import java.util.Date;

public class ReviewDTO {

    private int reviewCode;

    private String reviewTitle;

    private String reviewWriter;

    private String reviewDetail;

    private String rallyCode;

    private Date reviewWriteDate;
    public ReviewDTO() {}

    public ReviewDTO(int reviewCode, String reviewTitle, String reviewWriter, String reviewDetail, String rallyCode, Date reviewWriteDate) {
        this.reviewCode = reviewCode;
        this.reviewTitle = reviewTitle;
        this.reviewWriter = reviewWriter;
        this.reviewDetail = reviewDetail;
        this.rallyCode = rallyCode;
        this.reviewWriteDate = reviewWriteDate;
    }

    public int getReviewCode() {
        return reviewCode;
    }

    public void setReviewCode(int reviewCode) {
        this.reviewCode = reviewCode;
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

    public String getRallyCode() {
        return rallyCode;
    }

    public void setRallyCode(String rallyCode) {
        this.rallyCode = rallyCode;
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
                "reviewCode=" + reviewCode +
                ", reviewTitle='" + reviewTitle + '\'' +
                ", reviewWriter='" + reviewWriter + '\'' +
                ", reviewDetail='" + reviewDetail + '\'' +
                ", rallyCode='" + rallyCode + '\'' +
                ", reviewWriteDate=" + reviewWriteDate +
                '}';
    }
}
