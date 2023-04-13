package com.hamhabocca.dallibocca.comment.dto;

import java.util.Date;
import javax.persistence.Column;

public class CommenetDTO {

	private int memberId;
	private String nickname;
	private String comment;
	private java.util.Date commentWriteDate;

	public CommenetDTO() {
	}

	public CommenetDTO(int memberId, String nickname, String comment, Date commentWriteDate) {
		this.memberId = memberId;
		this.nickname = nickname;
		this.comment = comment;
		this.commentWriteDate = commentWriteDate;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCommentWriteDate() {
		return commentWriteDate;
	}

	public void setCommentWriteDate(Date commentWriteDate) {
		this.commentWriteDate = commentWriteDate;
	}

	@Override
	public String toString() {
		return "CommenetDTO{" +
			"memberId=" + memberId +
			", nickname='" + nickname + '\'' +
			", comment='" + comment + '\'' +
			", commentWriteDate=" + commentWriteDate +
			'}';
	}
}
