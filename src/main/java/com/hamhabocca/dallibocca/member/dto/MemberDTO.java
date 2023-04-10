package com.hamhabocca.dallibocca.member.dto;

import com.hamhabocca.dallibocca.member.entity.RiderProfile;

import javax.persistence.*;

public class MemberDTO {

	private String memberId;

	private String nickname;

	private int reportCount;

	private String socialLogin;

	private String loginToken;

	private boolean isDeleted;

	private RiderProfileDTO riderProfile;

	public MemberDTO() {}

	public MemberDTO(String memberId, String nickname, int reportCount, String socialLogin, String loginToken, boolean isDeleted, RiderProfileDTO riderProfile) {
		this.memberId = memberId;
		this.nickname = nickname;
		this.reportCount = reportCount;
		this.socialLogin = socialLogin;
		this.loginToken = loginToken;
		this.isDeleted = isDeleted;
		this.riderProfile = riderProfile;
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

	public RiderProfileDTO getRiderProfile() {
		return riderProfile;
	}

	public void setRiderProfile(RiderProfileDTO riderProfile) {
		this.riderProfile = riderProfile;
	}

	@Override
	public String toString() {
		return "MemberDTO{" +
				"memberId='" + memberId + '\'' +
				", nickname='" + nickname + '\'' +
				", reportCount=" + reportCount +
				", socialLogin='" + socialLogin + '\'' +
				", loginToken='" + loginToken + '\'' +
				", isDeleted=" + isDeleted +
				", riderProfile=" + riderProfile +
				'}';
	}
}
