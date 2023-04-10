package com.hamhabocca.dallibocca.member.entity;

import javax.persistence.*;

@Entity(name = "RiderProfile")
@Table(name = "rider_profile")
public class RiderProfile {

	@Id
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "member_id", referencedColumnName = "member_id")
	private String memberId;

	@Column(name = "level")
	private int level;

	@Column(name = "mileage")
	private int mileage;

	@Column(name = "preferred_location")
	private String preferredLocation;

	@Column(name = "preferred_type")
	private String preferredType;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Member member;

	public RiderProfile() {}

	public RiderProfile(String memberId, int level, int mileage, String preferredLocation, String preferredType) {
		this.memberId = memberId;
		this.level = level;
		this.mileage = mileage;
		this.preferredLocation = preferredLocation;
		this.preferredType = preferredType;
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

	@Override
	public String toString() {
		return "RiderProfile{" +
				"memberId='" + memberId + '\'' +
				", level=" + level +
				", mileage=" + mileage +
				", preferredLocation='" + preferredLocation + '\'' +
				", preferredType='" + preferredType + '\'' +
				'}';
	}
}
