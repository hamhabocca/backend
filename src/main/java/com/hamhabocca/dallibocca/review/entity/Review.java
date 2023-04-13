package com.hamhabocca.dallibocca.review.entity;


import javax.persistence.*;
import java.util.Date;

@Entity(name = "Review")  //엔티티매니저가 관리하기 위한 엔티티객체
@Table(name = "review")  //어떠한 데이터베이스의 테이블과 매핑할 것인지 지정

public class Review {


    @Id //리뷰 코드가 primary key
//    @GeneratedValue
    @Column(name = "REVIEW_CODE")
    private int reviewCode;

    @Column(name = "REVIEW_TITLE")
    private String reviewTitle;

    @Column(name = "REVIEW_WRITER")
    private String reviewWriter;

    @Column(name = "REVIEW_DETAIL")
    private String reviewDetail;

    @Column(name = "REVIEW_WRITE_DATE")
    private Date reviewWriteDate;

    @Column(name = "RALLY_CODE")
    private String rallyCode;

    public Review() {}


    public Review(int reviewCode, String reviewTitle, String reviewWriter, String reviewDetail, Date reviewWriteDate, String rallyCode) {
        this.reviewCode = reviewCode;
        this.reviewTitle = reviewTitle;
        this.reviewWriter = reviewWriter;
        this.reviewDetail = reviewDetail;
        this.reviewWriteDate = reviewWriteDate;
        this.rallyCode = rallyCode;
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

    public Date getReviewWriteDate() {
        return reviewWriteDate;
    }

    public void setReviewWriteDate(Date reviewWriteDate) {
        this.reviewWriteDate = reviewWriteDate;
    }

    public String getRallyCode() {
        return rallyCode;
    }

    public void setRallyCode(String rallyCode) {
        this.rallyCode = rallyCode;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewCode=" + reviewCode +
                ", reviewTitle='" + reviewTitle + '\'' +
                ", reviewWriter='" + reviewWriter + '\'' +
                ", reviewDetail='" + reviewDetail + '\'' +
                ", reviewWriteDate=" + reviewWriteDate +
                ", rallyCode='" + rallyCode + '\'' +
                '}';
    }
}
