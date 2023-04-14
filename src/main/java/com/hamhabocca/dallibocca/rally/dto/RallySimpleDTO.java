package com.hamhabocca.dallibocca.rally.dto;

import java.util.Date;

public class RallySimpleDTO {

	private long rallyId;
	private String rallyStatus;
	private String rallyName;
	private java.util.Date rallyDate;
	private String rallyStartLocation;
	private java.util.Date rallyWriteDate;

	public RallySimpleDTO() {}

	public RallySimpleDTO(long rallyId, String rallyStatus, String rallyName, Date rallyDate, String rallyStartLocation, Date rallyWriteDate) {
		this.rallyId = rallyId;
		this.rallyStatus = rallyStatus;
		this.rallyName = rallyName;
		this.rallyDate = rallyDate;
		this.rallyStartLocation = rallyStartLocation;
		this.rallyWriteDate = rallyWriteDate;
	}

	public long getrallyId() {
		return rallyId;
	}

	public void setrallyId(long rallyId) {
		this.rallyId = rallyId;
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

	public Date getRallyDate() {
		return rallyDate;
	}

	public void setRallyDate(Date rallyDate) {
		this.rallyDate = rallyDate;
	}

	public String getrallyStartLocation() {
		return rallyStartLocation;
	}

	public void setrallyStartLocation(String rallyStartLocation) {
		this.rallyStartLocation = rallyStartLocation;
	}

	public Date getRallyWriteDate() {
		return rallyWriteDate;
	}

	public void setRallyWriteDate(Date rallyWriteDate) {
		this.rallyWriteDate = rallyWriteDate;
	}

	@Override
	public String toString() {
		return "RallySimpleDTO{" +
				"rallyId=" + rallyId +
				", rallyStatus='" + rallyStatus + '\'' +
				", rallyName='" + rallyName + '\'' +
				", rallyDate=" + rallyDate +
				", rallyStartLocation='" + rallyStartLocation + '\'' +
				", rallyWriteDate=" + rallyWriteDate;
	}
}
