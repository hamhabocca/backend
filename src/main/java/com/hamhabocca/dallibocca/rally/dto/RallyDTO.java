package com.hamhabocca.dallibocca.rally.dto;

import java.util.Date;

public class RallyDTO {

	private int rallyId;
	private int rallyMasterId;   //memberId
	private String rallyStatus;
	private String rallyName;
	private java.util.Date rallyWriteDate;
	private String rallyType;
	private java.util.Date rallyDate;
	private String rallyStartLocation;
	private String rallyEndLocation;
	private int rallyDistance;
	private int rallyMinimum;
	private int rallyMaximum;
	private String rallyDetail;

	public RallyDTO() {
	}

	public RallyDTO(int rallyId, int rallyMasterId, String rallyStatus, String rallyName, Date rallyWriteDate, String rallyType, Date rallyDate, String rallyStartLocation, String rallyEndLocation, int rallyDistance, int rallyMinimum, int rallyMaximum, String rallyDetail) {
		this.rallyId = rallyId;
		this.rallyMasterId = rallyMasterId;
		this.rallyStatus = rallyStatus;
		this.rallyName = rallyName;
		this.rallyWriteDate = rallyWriteDate;
		this.rallyType = rallyType;
		this.rallyDate = rallyDate;
		this.rallyStartLocation = rallyStartLocation;
		this.rallyEndLocation = rallyEndLocation;
		this.rallyDistance = rallyDistance;
		this.rallyMinimum = rallyMinimum;
		this.rallyMaximum = rallyMaximum;
		this.rallyDetail = rallyDetail;
	}

	public int getRallyId() {
		return rallyId;
	}

	public void setRallyId(int rallyId) {
		this.rallyId = rallyId;
	}

	public int getRallyMasterId() {
		return rallyMasterId;
	}

	public void setRallyMasterId(int rallyMasterId) {
		this.rallyMasterId = rallyMasterId;
	}

	public String getRallyStatus() {
		return rallyStatus;
	}

	public void setRallyStatus(String rallyStatus) {
		this.rallyStatus = rallyStatus;
	}

	public String getRallyName() {
		return rallyName;
	}

	public void setRallyName(String rallyName) {
		this.rallyName = rallyName;
	}

	public Date getRallyWriteDate() {
		return rallyWriteDate;
	}

	public void setRallyWriteDate(Date rallyWriteDate) {
		this.rallyWriteDate = rallyWriteDate;
	}

	public String getRallyType() {
		return rallyType;
	}

	public void setRallyType(String rallyType) {
		this.rallyType = rallyType;
	}

	public Date getRallyDate() {
		return rallyDate;
	}

	public void setRallyDate(Date rallyDate) {
		this.rallyDate = rallyDate;
	}

	public String getRallyStartLocation() {
		return rallyStartLocation;
	}

	public void setRallyStartLocation(String rallyStartLocation) {
		this.rallyStartLocation = rallyStartLocation;
	}

	public String getRallyEndLocation() {
		return rallyEndLocation;
	}

	public void setRallyEndLocation(String rallyEndLocation) {
		this.rallyEndLocation = rallyEndLocation;
	}

	public int getRallyDistance() {
		return rallyDistance;
	}

	public void setRallyDistance(int rallyDistance) {
		this.rallyDistance = rallyDistance;
	}

	public int getRallyMinimum() {
		return rallyMinimum;
	}

	public void setRallyMinimum(int rallyMinimum) {
		this.rallyMinimum = rallyMinimum;
	}

	public int getRallyMaximum() {
		return rallyMaximum;
	}

	public void setRallyMaximum(int rallyMaximum) {
		this.rallyMaximum = rallyMaximum;
	}

	public String getRallyDetail() {
		return rallyDetail;
	}

	public void setRallyDetail(String rallyDetail) {
		this.rallyDetail = rallyDetail;
	}

	@Override
	public String toString() {
		return "RallyDTO{" +
				"rallyId=" + rallyId +
				", rallyMasterId=" + rallyMasterId +
				", rallyStatus='" + rallyStatus + '\'' +
				", rallyName='" + rallyName + '\'' +
				", rallyWriteDate=" + rallyWriteDate +
				", rallyType='" + rallyType + '\'' +
				", rallyDate=" + rallyDate +
				", rallyStartLocation='" + rallyStartLocation + '\'' +
				", rallyEndLocation='" + rallyEndLocation + '\'' +
				", rallyDistance=" + rallyDistance +
				", rallyMinimum=" + rallyMinimum +
				", rallyMaximum=" + rallyMaximum +
				", rallyDetail='" + rallyDetail + '\'' +
				'}';
	}
}
