package com.hamhabocca.dallibocca.rally.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@DynamicInsert
@DynamicUpdate
@Entity(name = "RallyMate")
@Table(name = "rally_mate")
@SequenceGenerator(
		name = "rallymate_sequence_generator",
		sequenceName = "sequence_rally_mate_id",
		initialValue = 1,
		allocationSize = 50
)
public class RallyMate {

	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "rallymate_sequence_generator"
	)
	@Column(name = "id")
	private long id;

	@Column(name = "rally_id")
	private long rallyId;

	@Column(name = "member_id")
	private long memberId;

	@Column(name = "participation_date", nullable = false)
	private java.util.Date participationDate;

	@Column(name = "is_accepted", length = 2)
	@ColumnDefault("'N'")
	private String isAccepted;

	public RallyMate() {}

	public RallyMate(long id, long rallyId, long memberId, Date participationDate, String isAccepted) {
		this.id = id;
		this.rallyId = rallyId;
		this.memberId = memberId;
		this.participationDate = participationDate;
		this.isAccepted = isAccepted;
	}

	public long getid() {
		return id;
	}

	public void setid(long id) {
		this.id = id;
	}

	public long getRallyId() {
		return rallyId;
	}

	public void setRallyId(long rallyId) {
		this.rallyId = rallyId;
	}

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
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
		return "RallyMate{" +
				"id=" + id +
				", rallyId=" + rallyId +
				", memberId=" + memberId +
				", participationDate=" + participationDate +
				", isAccepted='" + isAccepted + '\'' +
				'}';
	}
}
