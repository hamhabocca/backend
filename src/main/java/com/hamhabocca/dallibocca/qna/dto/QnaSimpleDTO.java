package com.hamhabocca.dallibocca.qna.dto;

import java.util.Date;

public class QnaSimpleDTO {

	private long qnaId;
	private String qnaTitle;
	private String qnaCategory;
	private String qnaWriter;
	private java.util.Date qnaWriteDate;

	public QnaSimpleDTO() {
	}

	public QnaSimpleDTO(long qnaId, String qnaTitle, String qnaCategory, String qnaWriter,
		Date qnaWriteDate) {
		this.qnaId = qnaId;
		this.qnaTitle = qnaTitle;
		this.qnaCategory = qnaCategory;
		this.qnaWriter = qnaWriter;
		this.qnaWriteDate = qnaWriteDate;
	}

	public long getQnaId() {
		return qnaId;
	}

	public void setQnaId(long qnaId) {
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

	public Date getQnaWriteDate() {
		return qnaWriteDate;
	}

	public void setQnaWriteDate(Date qnaWriteDate) {
		this.qnaWriteDate = qnaWriteDate;
	}

	@Override
	public String toString() {
		return "QnaSimpleDTO{" +
			"qnaId=" + qnaId +
			", qnaTitle='" + qnaTitle + '\'' +
			", qnaCategory='" + qnaCategory + '\'' +
			", qnaWriter='" + qnaWriter + '\'' +
			", qnaWriteDate=" + qnaWriteDate +
			'}';
	}
}
