package com.hamhabocca.dallibocca.rally.dto;

import java.util.Date;

public class RallyMateDTO {

	private int rallyMateId;
	private int rallyId;
	private int memberId;
	private java.util.Date participationDate;
	private String isAccepted;

	public RallyMateDTO() {}

	public RallyMateDTO(int rallyMateId, int rallyId, int memberId, Date participationDate, String isAccepted) {
		this.rallyMateId = rallyMateId;
		this.rallyId = rallyId;
		this.memberId = memberId;
		this.participationDate = participationDate;
		this.isAccepted = isAccepted;
	}

	public int getRallyMateId() {
		return rallyMateId;
	}

	public void setRallyMateId(int rallyMateId) {
		this.rallyMateId = rallyMateId;
	}

	public int getRallyId() {
		return rallyId;
	}

	public void setRallyId(int rallyId) {
		this.rallyId = rallyId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Date getParticipationDate() {
		return participationDate;
	}

	public void setParticipationDate(Date participationDate) {
		this.participationDate = participationDate;
	}

	public String getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(String isAccepted) {
		this.isAccepted = isAccepted;
	}

	@Override
	public String toString() {
		return "RallyMateDTO{" +
				"rallyMateId=" + rallyMateId +
				", rallyId=" + rallyId +
				", memberId=" + memberId +
				", participationDate=" + participationDate +
				", isAccepted='" + isAccepted + '\'' +
				'}';
	}
}
