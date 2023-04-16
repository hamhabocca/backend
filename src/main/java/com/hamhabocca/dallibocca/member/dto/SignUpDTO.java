package com.hamhabocca.dallibocca.member.dto;

import java.sql.Date;
import java.time.LocalDateTime;

public class SignUpDTO {

    private String nickname;

    private String socialLogin;

    private long socialId;

    private LocalDateTime signUpDate;

    public SignUpDTO() {};

    public SignUpDTO(String nickname, String socialLogin, long socialId, LocalDateTime signUpDate) {
        this.nickname = nickname;
        this.socialLogin = socialLogin;
        this.socialId = socialId;
        this.signUpDate = signUpDate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public LocalDateTime getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(LocalDateTime signUpDate) {
        this.signUpDate = signUpDate;
    }

    @Override
    public String toString() {
        return "SignUpDTO{" +
            "nickname='" + nickname + '\'' +
            ", socialLogin='" + socialLogin + '\'' +
            ", socialId=" + socialId +
            ", signUpDate=" + signUpDate +
            '}';
    }
}
