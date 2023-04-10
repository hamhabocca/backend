package com.hamhabocca.dallibocca.member.dto;

import com.hamhabocca.dallibocca.member.entity.Member;

import javax.persistence.*;

public class RiderProfileDTO {

	private String memberId;

	private int level;

	private int mileage;

	private String preferredLocation;

	private String preferredType;

	private MemberDTO member;

	public RiderProfileDTO() {}

	public RiderProfileDTO(String memberId, int level, int mileage, String preferredLocation, String preferredType, MemberDTO member) {
		this.memberId = memberId;
		this.level = level;
		this.mileage = mileage;
		this.preferredLocation = preferredLocation;
		this.preferredType = preferredType;
		this.member = member;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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

	public MemberDTO getMember() {
		return member;
	}

	public void setMember(MemberDTO member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "RiderProfileDTO{" +
				"memberId='" + memberId + '\'' +
				", level=" + level +
				", mileage=" + mileage +
				", preferredLocation='" + preferredLocation + '\'' +
				", preferredType='" + preferredType + '\'' +
				", member=" + member +
				'}';
	}
}
