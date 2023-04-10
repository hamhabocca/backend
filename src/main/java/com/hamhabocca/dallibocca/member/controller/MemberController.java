package com.hamhabocca.dallibocca.member.controller;

import com.hamhabocca.dallibocca.common.ResponseMessage;
import com.hamhabocca.dallibocca.member.dto.MemberDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "멤버 관련 기능 API")
@RestController
@RequestMapping("/api/v1")
public class MemberController {

    private final List<MemberDTO> members;

    public MemberController() {

        members = new ArrayList<>();

    }

    @ApiOperation(value = "테스트용 멤버 추가")
    @PostMapping("/members/regist-for-test")
    public ResponseEntity<ResponseMessage> registUserForTesting(@RequestBody MemberDTO newMember) {

        members.add(newMember);

        return ResponseEntity
                .created(URI.create("/swagger/members/" + newMember.getMemberId()))
                .build();
    }
}
