package com.hamhabocca.dallibocca.qna.dto;

import java.util.Date;

public class QnaDTO {

    private int qnaId;
    private String qnaTitle;
    private String qnaCategory;
    private String qnaWriter;
    private String qnaDetail;
    private java.util.Date qnaWriteDate;

    public QnaDTO() {}

    public QnaDTO(int qnaId, String qnaTitle, String qnaCategory, String qnaWriter, String qnaDetail, Date qnaWriteDate) {
        this.qnaId = qnaId;
        this.qnaTitle = qnaTitle;
        this.qnaCategory = qnaCategory;
        this.qnaWriter = qnaWriter;
        this.qnaDetail = qnaDetail;
        this.qnaWriteDate = qnaWriteDate;
    }

    public int getQnaId() {
        return qnaId;
    }

    public void setQnaId(int qnaId) {
        this.qnaId = qnaId;
    }

    public String getQnaTitle() {
        return qnaTitle;
    }

    public void setQnaTitle(String qnaTitle) {
        this.qnaTitle = qnaTitle;
    }

    public String getQnaCategory() {
        return qnaCategory;
    }

    public void setQnaCategory(String qnaCategory) {
        this.qnaCategory = qnaCategory;
    }

    public String getQnaWriter() {
        return qnaWriter;
    }

    public void setQnaWriter(String qnaWriter) {
        this.qnaWriter = qnaWriter;
    }

    public String getQnaDetail() {
        return qnaDetail;
    }

    public void setQnaDetail(String qnaDetail) {
        this.qnaDetail = qnaDetail;
    }

    public Date getQnaWriteDate() {
        return qnaWriteDate;
    }

    public void setQnaWriteDate(Date qnaWriteDate) {
        this.qnaWriteDate = qnaWriteDate;
    }

    @Override
    public String toString() {
        return "QnaDTO{" +
                "qnaId=" + qnaId +
                ", qnaTitle='" + qnaTitle + '\'' +
                ", qnaCategory='" + qnaCategory + '\'' +
                ", qnaWriter='" + qnaWriter + '\'' +
                ", qnaDetail='" + qnaDetail + '\'' +
                ", qnaWriteDate=" + qnaWriteDate +
                '}';
    }
}
