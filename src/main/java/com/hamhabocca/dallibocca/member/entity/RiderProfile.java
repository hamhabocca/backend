package com.hamhabocca.dallibocca.member.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "RiderProfile")
@Table(name = "rider_profile")
public class RiderProfile {

	@Id
	@Column(name = "member_id")
	private int memberId;

	@Column(name = "level")
	@ColumnDefault("1")
	private int level;

	@Column(name = "mileage")
	@ColumnDefault("0")
	private int mileage;

	@Column(name = "preferred_location")
	private String preferredLocation;

	@Column(name = "preferred_type")
	private String preferredType;

	@MapsId
	@OneToOne
	@JoinColumn(name = "member_id")
	private Member member;

	public RiderProfile() {}

	public RiderProfile(int memberId, int level, int mileage, String preferredLocation, String preferredType) {
		this.memberId = memberId;
		this.level = level;
		this.mileage = mileage;
		this.preferredLocation = preferredLocation;
		this.preferredType = preferredType;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
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