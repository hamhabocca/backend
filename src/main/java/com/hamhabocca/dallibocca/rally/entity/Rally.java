package com.hamhabocca.dallibocca.rally.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@DynamicInsert
@DynamicUpdate
@Entity(name = "Rally")
@Table(name = "rally")
@SequenceGenerator(
		name = "rally_sequence_generator",
		sequenceName = "sequence_rally_id",
		initialValue = 1,
		allocationSize = 50
)
public class Rally {

	@Id
	@Column(name = "rally_id")
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "rally_sequence_generator"
	)
	private int rallyId;

	@Column(name = "rally_master_id", nullable = false)
	private int rallyMasterId;   //memberId

	@Column(name = "rally_status")
	@ColumnDefault("'모집중'")
	private String rallyStatus;

	@Column(name = "rally_name", nullable = false)
	private String rallyName;

	@Column(name = "rally_write_date")
	private java.util.Date rallyWriteDate;

	@Column(name = "rally_type", nullable = false)
	private String rallyType;

	@Column(name = "rally_date")
	private java.util.Date rallyDate;

	@Column(name = "rally_start_location")
	private String rallyStartLocation;

	@Column(name = "rally_end_location")
	private String rallyEndLocation;

	@Column(name = "rally_distance")
	private int rallyDistance;

	@Column(name = "rally_minimum")
	private int rallyMinimum;

	@Column(name = "rally_maximum")
	private int rallyMaximum;

	@Column(name = "rally_detail")
	private String rallyDetail;

	public Rally() {}

	public Rally(int rallyId, int rallyMasterId, String rallyStatus, String rallyName, Date rallyWriteDate, String rallyType, Date rallyDate, String rallyStartLocation, String rallyEndLocation, int rallyDistance, int rallyMinimum, int rallyMaximum, String rallyDetail) {

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
		return "Rally{" +
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
