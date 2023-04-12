package com.hamhabocca.dallibocca.member.dto;

import java.net.URL;

public class MemberSimpleDTO {

    private int memberId;

    private String nickname;

    private String linkToMyPage;

    public MemberSimpleDTO() {}

    public MemberSimpleDTO(int memberId, String nickname) {
        this.memberId = memberId;
        this.nickname = nickname;
    }

    public MemberSimpleDTO(int memberId, String nickname, String linkToMyPage) {
        this.memberId = memberId;
        this.nickname = nickname;
        this.linkToMyPage = linkToMyPage;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLinkToMyPage() {
        return linkToMyPage;
    }

    public void setLinkToMyPage(String linkToMyPage) {
        this.linkToMyPage = linkToMyPage;
    }

    @Override
    public String toString() {
        return "MemberSimpleDTO{" +
                "memberId=" + memberId +
                ", nickname='" + nickname + '\'' +
                ", linkToMyPage=" + linkToMyPage +
                '}';
    }
}
