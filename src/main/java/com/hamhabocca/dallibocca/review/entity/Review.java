package com.hamhabocca.dallibocca.review.entity;


import javax.persistence.*;
import java.util.Date;

@Entity(name = "Review")  //엔티티매니저가 관리하기 위한 엔티티객체
@Table(name = "review")  //어떠한 데이터베이스의 테이블과 매핑할 것인지 지정
@SequenceGenerator(
    name = "review_sequence_generator",
    sequenceName = "sequence_review_id",
    initialValue = 1,
    allocationSize = 50
)
public class Review {


    @Id //리뷰 코드가 primary key
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "review_sequence_generator"
    )
    @Column(name = "REVIEW_ID")
    private Long reviewId;

    @Column(name = "REVIEW_TITLE")
    private String reviewTitle;

    @Column(name = "REVIEW_WRITER")
    private String reviewWriter;

    @Column(name = "REVIEW_DETAIL")
    private String reviewDetail;

    @Column(name = "REVIEW_WRITE_DATE")
    private Date reviewWriteDate;

    @Column(name = "RALLY_ID")
    private String rallyId;

    public Review() {}


    public Review(Long reviewId, String reviewTitle, String reviewWriter, String reviewDetail,
        Date reviewWriteDate, String rallyId) {
        this.reviewId = reviewId;
        this.reviewTitle = reviewTitle;
        this.reviewWriter = reviewWriter;
        this.reviewDetail = reviewDetail;
        this.reviewWriteDate = reviewWriteDate;
        this.rallyId = rallyId;
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

    public Date getReviewWriteDate() {
        return reviewWriteDate;
    }

    public void setReviewWriteDate(Date reviewWriteDate) {
        this.reviewWriteDate = reviewWriteDate;
    }

    public String getRallyId() {
        return rallyId;
    }

    public void setRallyId(String rallyId) {
        this.rallyId = rallyId;
    }

    @Override
    public String toString() {
        return "Review{" +
            "reviewId=" + reviewId +
            ", reviewTitle='" + reviewTitle + '\'' +
            ", reviewWriter='" + reviewWriter + '\'' +
            ", reviewDetail='" + reviewDetail + '\'' +
            ", reviewWriteDate=" + reviewWriteDate +
            ", rallyId='" + rallyId + '\'' +
            '}';
    }
}
