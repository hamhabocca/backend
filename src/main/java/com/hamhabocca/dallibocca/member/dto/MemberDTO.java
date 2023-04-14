package com.hamhabocca.dallibocca.member.dto;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

public class MemberDTO {

	private long memberId;

	private String nickname;

	private int reportCount;

	private String socialLogin;

	private long socialId;

	private String loginToken;

	private String email;

	private String gender;

	private String isDeleted;

	private java.sql.Date signUpDate;

	private java.sql.Date deletedDate;

	private int level;

	private int mileage;

	private String preferredLocation;

	private String preferredType;

	public MemberDTO() {}

	public MemberDTO(long memberId, String nickname, int reportCount, String socialLogin,
		long socialId,
		String loginToken, String email, String gender, String isDeleted, Date signUpDate, Date deletedDate,
		int level,
		int mileage, String preferredLocation, String preferredType) {
		this.memberId = memberId;
		this.nickname = nickname;
		this.reportCount = reportCount;
		this.socialLogin = socialLogin;
		this.socialId = socialId;
		this.loginToken = loginToken;
		this.email = email;
		this.gender = gender;
		this.isDeleted = isDeleted;
		this.signUpDate = signUpDate;
		this.deletedDate = deletedDate;
		this.level = level;
		this.mileage = mileage;
		this.preferredLocation = preferredLocation;
		this.preferredType = preferredType;
	}

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
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

	public long getSocialId() {
		return socialId;
	}

	public void setSocialId(long socialId) {
		this.socialId = socialId;
	}

	public String getLoginToken() {
		return loginToken;
	}

	public void setLoginToken(String loginToken) {
		this.loginToken = loginToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getPreferredLocation() {
		return preferredLocation;
	}

	public void setPreferredLocation(String preferredLocation) {
		this.preferredLocation = preferredLocation;
	}

	public String getPreferredType() {
		return preferredType;
	}

	public void setPreferredType(String preferredType) {
		this.preferredType = preferredType;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "MemberDTO{" +
			"memberId=" + memberId +
			", nickname='" + nickname + '\'' +
			", reportCount=" + reportCount +
			", socialLogin='" + socialLogin + '\'' +
			", socialId=" + socialId +
			", loginToken='" + loginToken + '\'' +
			", email='" + email + '\'' +
			", gender='" + gender + '\'' +
			", isDeleted='" + isDeleted + '\'' +
			", signUpDate=" + signUpDate +
			", deletedDate=" + deletedDate +
			", level=" + level +
			", mileage=" + mileage +
			", preferredLocation='" + preferredLocation + '\'' +
			", preferredType='" + preferredType + '\'' +
			'}';
	}
}
