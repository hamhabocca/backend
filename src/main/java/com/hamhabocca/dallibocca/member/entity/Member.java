package com.hamhabocca.dallibocca.member.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity(name = "Member")
@Table(name = "member")
@SequenceGenerator(
		name = "member_sequence_generator",
		sequenceName = "sequence_member_id",
		initialValue = 1,
		allocationSize = 50
)
public class Member {

	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "member_sequence_generator"
	)
	@Column(name = "member_id")
	private int memberId;

	@Column(name = "nickname", unique = true, nullable = false)
	private String nickname;

	@Column(name = "report_count")
	@ColumnDefault("0")
	private int reportCount;

	@Column(name = "social_login", nullable = false)
	private String socialLogin;

	@Column(name = "login_token", nullable = false)
	private String loginToken;

	@Column(name = "is_deleted", columnDefinition = "varchar (2)")
	@ColumnDefault("'N'")
	private String isDeleted;

	@Column(name = "sign_up_date", nullable = false)
	private java.sql.Date signUpDate;

	@Column(name = "deleted_date")
	private java.sql.Date deletedDate;

	@OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
	private RiderProfile riderProfile;

	public Member() {}

	public Member(int memberId, String nickname, int reportCount, String socialLogin, String loginToken, String isDeleted) {
		this.memberId = memberId;
		this.nickname = nickname;
		this.reportCount = reportCount;
		this.socialLogin = socialLogin;
		this.loginToken = loginToken;
		this.isDeleted = isDeleted;
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

	public int getReportCount() {
		return reportCount;
	}

	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}

	public String getSocialLogin() {
		return socialLogin;
	}

	public void setSocialLogin(String socialLogin) {
		this.socialLogin = socialLogin;
	}

	public String getLoginToken() {
		return loginToken;
	}

	public void setLoginToken(String loginToken) {
		this.loginToken = loginToken;
	}

	public String isDeleted() {
		return isDeleted;
	}

	public void setDeleted(String deleted) {
		isDeleted = deleted;
	}

	public Date getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	public RiderProfile getRiderProfile() {
		return riderProfile;
	}

	public void setRiderProfile(RiderProfile riderProfile) {
		this.riderProfile = riderProfile;
	}

	@Override
	public String toString() {
		return "Member{" +
				"memberId=" + memberId +
				", nickname='" + nickname + '\'' +
				", reportCount=" + reportCount +
				", socialLogin='" + socialLogin + '\'' +
				", loginToken='" + loginToken + '\'' +
				", isDeleted='" + isDeleted + '\'' +
				", signUpDate=" + signUpDate +
				", deletedDate=" + deletedDate +
				", riderProfile=" + riderProfile +
				'}';
	}
}