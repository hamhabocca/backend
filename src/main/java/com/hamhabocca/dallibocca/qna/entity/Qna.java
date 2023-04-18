package com.hamhabocca.dallibocca.qna.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Qna")
@Table(name = "qna")
@SequenceGenerator(
	name = "qna_sequence_generator",
	sequenceName = "sequence_qna_id",
	initialValue = 1,
	allocationSize = 50
)
public class Qna {

	@Id
	@Column(name = "qna_id")
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "qna_sequence_generator"
	)
	private long qnaId;

	@Column(name = "qna_title")
	private String qnaTitle;

	@Column(name = "qna_category")
	private String qnaCategory;

	@Column(name = "qna_writer")
	private String qnaWriter;

	@Column(name = "qna_detail")
	private String qnaDetail;

	@Column(name = "qna_write_date")
	private Date qnaWriteDate;

	public Qna() {
	}

	public Qna(long qnaId, String qnaTitle, String qnaCategory, String qnaWriter, String qnaDetail,
		Date qnaWriteDate) {
		this.qnaId = qnaId;
		this.qnaTitle = qnaTitle;
		this.qnaCategory = qnaCategory;
		this.qnaWriter = qnaWriter;
		this.qnaDetail = qnaDetail;
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
		return "Qna{" +
			"qnaId=" + qnaId +
			", qnaTitle='" + qnaTitle + '\'' +
			", qnaCategory='" + qnaCategory + '\'' +
			", qnaWriter='" + qnaWriter + '\'' +
			", qnaDetail='" + qnaDetail + '\'' +
			", qnaWriteDate=" + qnaWriteDate +
			'}';
	}
}
