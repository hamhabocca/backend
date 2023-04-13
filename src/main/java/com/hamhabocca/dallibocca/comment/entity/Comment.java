package com.hamhabocca.dallibocca.comment.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Comment")
@Table(name = "comment")
public class Comment {

	@Id
	@Column(name = "member_id")
	private int memberId;

	@Column(name = "nickname")
	private String nickname;

	@Column(name = "comment")
	private String comment;

	@Column(name = "comment_write_date")
	private Date commentWriteDate;

	public Comment() {
	}

	public Comment(int memberId, String nickname, String comment, Date commentWriteDate) {
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
		return "Comment{" +
			"memberId=" + memberId +
			", nickname='" + nickname + '\'' +
			", comment='" + comment + '\'' +
			", commentWriteDate=" + commentWriteDate +
			'}';
	}
}
