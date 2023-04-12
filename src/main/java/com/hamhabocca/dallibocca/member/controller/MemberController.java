package com.hamhabocca.dallibocca.member.controller;

import com.hamhabocca.dallibocca.common.ResponseMessage;
import com.hamhabocca.dallibocca.member.dto.MemberDTO;
import com.hamhabocca.dallibocca.member.dto.MemberSimpleDTO;
import com.hamhabocca.dallibocca.member.dto.SignUpDTO;
import com.hamhabocca.dallibocca.member.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "멤버 관련 기능 API")
@RestController
@RequestMapping("/api/v1")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {

        this.memberService = memberService;
    }

    @ApiOperation(value = "테스트용 멤버 추가")
    @PostMapping("/members/regist-for-test")
    public ResponseEntity<ResponseMessage> registUserForTesting(@RequestBody SignUpDTO newMemberInfo) {

        MemberDTO newMember = new MemberDTO();

        newMember.setNickname(newMemberInfo.getNickname());
        newMember.setSocialLogin(newMemberInfo.getSocialLogin());
        newMember.setLoginToken(newMemberInfo.getLoginToken());
        newMember.setSignUpDate(newMemberInfo.getSignUpDate());

        memberService.registNewMemberTest(newMember);

        return ResponseEntity
                .created(URI.create("/api/v1/members/regist-for-test/"))
                .build();
    }

    @ApiOperation(value = "멤버 이름, 프사(예정), 마이페이지로 가는 링크만 id로 조회")
    @GetMapping("/members/simple/{memberId}")
    public ResponseEntity<ResponseMessage> findMemberByIdSimple(@PathVariable int memberId) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

//        MemberSimpleDTO member = memberService.findMemberByIdSimple(memberId);

        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.put("member", member);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseMessage(200, "찾았다~", responseMap));
    }

    @ApiOperation(value = "멤버 id로 조회")
    @GetMapping("/members/{memberId}")
    public ResponseEntity<ResponseMessage> findMemberById(@PathVariable int memberId) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        MemberDTO foundMember = memberService.findMemberById(memberId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("member", foundMember);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseMessage(200, "찾았다~", responseMap));
    }

    @ApiOperation(value = "멤버 전체 조회")
    @GetMapping("/members")
    public ResponseEntity<ResponseMessage> findAllMembers() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        List<MemberDTO> memberList = memberService.findAllMembers();

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("members", memberList);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseMessage(200, "찾았다~!!", responseMap));
    }

    @ApiOperation(value = "멤버 프로필 수정")
    @ApiResponses({
            @ApiResponse(code = 201, message = "수정성공..."),
            @ApiResponse(code = 400, message = "잘못된 파라미터....")
    })
    @PutMapping("/members/{memberId}")
    public ResponseEntity<?> modifyMember(@RequestBody MemberDTO modifyInfo, @PathVariable int memberId) {

        memberService.modifyMember(modifyInfo, memberId);

        return ResponseEntity
                .noContent()
                .build();
    }
}
