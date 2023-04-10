package com.hamhabocca.dallibocca.rally.entity;

import javax.persistence.*;

@Entity(name = "MemberByRally")
@Table(name = "member")
//@SequenceGenerator(
//		name = "member_sequence_generator",
//		sequenceName = "sequence_member_id",
//		initialValue = 1,
//		allocationSize = 50
//)
public class MemberByRally {

	@Id
//	@GeneratedValue(
//			strategy = GenerationType.IDENTITY,
//			generator = "member_sequence_generator"
//	)
	@OneToOne(mappedBy = "RiderProfile")
	@Column(name = "member_id")
	private String memberId;

	@Column(name = "nickname")
	private String nickname;

	@Column(name = "report_count")
	private int reportCount;

	@Column(name = "social_login")
	private String socialLogin;

	@Column(name = "login_token")
	private String loginToken;

	@Column(name = "is_deleted")
	private boolean isDeleted;

	public MemberByRally() {}

	public MemberByRally(String memberId, String nickname, int reportCount, String socialLogin, String loginToken, boolean isDeleted) {
		this.memberId = memberId;
		this.nickname = nickname;
		this.reportCount = reportCount;
		this.socialLogin = socialLogin;
		this.loginToken = loginToken;
		this.isDeleted = isDeleted;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
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

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean deleted) {
		isDeleted = deleted;
	}

	@Override
	public String toString() {
		return "Member{" +
				"memberId='" + memberId + '\'' +
				", nickname='" + nickname + '\'' +
				", reportCount=" + reportCount +
				", socialLogin='" + socialLogin + '\'' +
				", loginToken='" + loginToken + '\'' +
				", isDeleted=" + isDeleted +
				'}';
	}
}
