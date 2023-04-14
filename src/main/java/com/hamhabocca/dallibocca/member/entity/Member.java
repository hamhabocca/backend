package com.hamhabocca.dallibocca.member.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity(name = "Member")
@Table(name = "member")
@SequenceGenerator(
        name = "member_sequence_generator",
        sequenceName = "sequence_member_id",
        initialValue = 1,
        allocationSize = 50
)
public class Member {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member_sequence_generator"
    )
    @Column(name = "member_id")
    private long memberId;

    @Column(name = "nickname", unique = true, nullable = false)
    private String nickname;

    @Column(name = "report_count", nullable = false)
    private int reportCount;

    @Column(name = "social_login", nullable = false)
    private String socialLogin;

    @Column(name = "social_id", nullable = false)
    private long socialId;

    @Column(name = "login_token", nullable = false)
    private String loginToken;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "is_deleted", columnDefinition = "varchar (2)", nullable = false)
    private String isDeleted;

    @Column(name = "sign_up_date", nullable = false)
    private java.sql.Date signUpDate;

    @Column(name = "deleted_date")
    private java.sql.Date deletedDate;

    @Column(name = "level", nullable = false)
    private int level;

    @Column(name = "mileage", nullable = false)
    @ColumnDefault("0")
    private int mileage;

    @Column(name = "preferred_location")
    private String preferredLocation;

    @Column(name = "preferred_type")
    private String preferredType;


    public Member() {}

    public Member(long memberId, String nickname, int reportCount, String socialLogin,
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

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
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


    public long getSocialId() {
        return socialId;
    }

    public void setSocialId(long socialId) {
        this.socialId = socialId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Member{" +
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
