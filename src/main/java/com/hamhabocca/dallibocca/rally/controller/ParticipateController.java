package com.hamhabocca.dallibocca.rally.controller;

import com.hamhabocca.dallibocca.common.ResponseMessage;
import com.hamhabocca.dallibocca.rally.dto.RallyMateDTO;
import com.hamhabocca.dallibocca.rally.service.ParticipateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "Rally Participate API")
@RestController
@RequestMapping("/api/v1")
public class ParticipateController {

    private final ParticipateService participateService;

    @Autowired
    public ParticipateController(ParticipateService participateService) {
        this.participateService = participateService;
    }

    @ApiOperation(value = "랠리 신청 현황 API")
    @ApiResponses({
        @ApiResponse(code = 200, message = "[OK]"),
        @ApiResponse(code = 400, message = "[Bad Request]")
    })
    @GetMapping("/rallies/{rallyId}/mate-list")
    public ResponseEntity<ResponseMessage> findRallyMateListByRallyId(@PathVariable long rallyId) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        List<RallyMateDTO> rallyMateList = participateService.findRallyMateList(rallyId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("rallyMateList", rallyMateList);

        return ResponseEntity.ok().headers(headers)
            .body(new ResponseMessage(200, "신청현황 조회 성공", responseMap));
    }

    @ApiOperation(value = "랠리 참가 신청 API")
    @ApiResponses({
        @ApiResponse(code = 201, message = "[Created]"),
        @ApiResponse(code = 400, message = "[Bad Request]"),
        @ApiResponse(code = 403, message = "[Forbidden]")
    })
    @PostMapping("/rallies/{rallyId}/mate-list")
    public ResponseEntity<?> participateRallyByMate(@PathVariable long rallyId,
        @RequestHeader(value = "memberId") long memberId) {

        participateService.participateByMate(rallyId, memberId);

        return ResponseEntity.created(
                URI.create("/api/v1/rallies/" + rallyId + "/mate-list/" + memberId))
            .build();
    }

    @ApiOperation(value = "랠리 참가 취소 API")
    @ApiResponses({
        @ApiResponse(code = 204, message = "[No Content]"),
        @ApiResponse(code = 400, message = "[Bad Request]")
    })
    @DeleteMapping("/rallies/{rallyId}/mate-list")
    public ResponseEntity<?> cancelParticipateRally(@PathVariable long rallyId,
        @RequestHeader(value = "currentMemberId") long currentMemberId) {

        participateService.cancelParticipateByMate(rallyId, currentMemberId);

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "랠리 참가신청 승인 API")
    @ApiResponses({
        @ApiResponse(code = 201, message = "[Created]"),
        @ApiResponse(code = 400, message = "[Bad Request]")
    })
    @PutMapping("/rallies/{rallyId}/mate-list")
    public ResponseEntity<?> allowParticipateByMaster(@PathVariable long rallyId, long mateId) {

        participateService.allowParticipate(rallyId, mateId);

        return ResponseEntity.created(
            URI.create("/api/v1/rallies/" + rallyId + "/mate-list/" + mateId)).build();
    }

}
