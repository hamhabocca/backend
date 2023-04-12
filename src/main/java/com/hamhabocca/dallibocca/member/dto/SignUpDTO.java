package com.hamhabocca.dallibocca.member.dto;

import java.sql.Date;

public class SignUpDTO {

    private String nickname;

    private String socialLogin;

    private String loginToken;

    private java.sql.Date signUpDate;

    public SignUpDTO() {};

    public SignUpDTO(String nickname, String socialLogin, String loginToken, Date signUpDate) {
        this.nickname = nickname;
        this.socialLogin = socialLogin;
        this.loginToken = loginToken;
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

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public Date getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(Date signUpDate) {
        this.signUpDate = signUpDate;
    }

    @Override
    public String toString() {
        return "SignUpDTO{" +
                "nickname='" + nickname + '\'' +
                ", socialLogin='" + socialLogin + '\'' +
                ", loginToken='" + loginToken + '\'' +
                ", signUpDate=" + signUpDate +
                '}';
    }
}
