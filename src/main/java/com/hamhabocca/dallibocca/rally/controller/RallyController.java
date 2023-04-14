package com.hamhabocca.dallibocca.rally.controller;

import com.hamhabocca.dallibocca.common.ResponseMessage;
import com.hamhabocca.dallibocca.common.page.Pagination;
import com.hamhabocca.dallibocca.common.page.PagingButtonInfo;
import com.hamhabocca.dallibocca.rally.dto.RallyDTO;
import com.hamhabocca.dallibocca.rally.dto.RallySimpleDTO;
import com.hamhabocca.dallibocca.rally.dto.SearchFilter;
import com.hamhabocca.dallibocca.rally.service.RallyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "랠리 게시글 컨트롤러")
@RestController
@RequestMapping("/api/v1")
public class RallyController {

    private final RallyService rallyService;

    @Autowired
    public RallyController(RallyService rallyService) {
        this.rallyService = rallyService;
    }

    @ApiOperation(value = "모든 랠리 목록 조회 API")
    @ApiResponses({
        @ApiResponse(code = 200, message = "[Ok]"),
        @ApiResponse(code = 404, message = "[Not Found]")
    })
    @GetMapping("/rallies")
    public ResponseEntity<ResponseMessage> findRallyList(@PageableDefault(size = 15) Pageable pageable) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Page<RallySimpleDTO> rallyList = rallyService.findRallyList(pageable);

        PagingButtonInfo paging = Pagination.getPagingButtonInfo(rallyList);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("rallyList", rallyList);
        responseMap.put("paging", paging);

        return ResponseEntity.ok().headers(headers)
            .body(new ResponseMessage(200, "전체 조회 성공", responseMap));
    }

    @ApiOperation(value = "랠리글 상세 조회 API")
    @ApiResponses({
        @ApiResponse(code = 200, message = "[Ok]"),
        @ApiResponse(code = 400, message = "[Bad Request]"),
        @ApiResponse(code = 403, message = "[Forbidden]"),
        @ApiResponse(code = 404, message = "[Not Found]")
    })
    @GetMapping("/rallies/{rallyId}")
    public ResponseEntity<ResponseMessage> findRallyById(@PathVariable int rallyId) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        RallyDTO foundRally = rallyService.findRallyById(rallyId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("rally", foundRally);

        return ResponseEntity.ok().headers(headers)
            .body(new ResponseMessage(200, "개별 조회 성공", responseMap));
    }

    @ApiOperation(value = "랠리글 추가 API")
    @ApiResponses({
        @ApiResponse(code = 201, message = "[Created]"),
        @ApiResponse(code = 400, message = "[Bad Request]"),
        @ApiResponse(code = 403, message = "[Forbidden]")
    })
    @PostMapping("/rallies")
    public ResponseEntity<?> postRally(@RequestBody RallyDTO newRally) {

        long currentId = rallyService.postNewRally(newRally);

        return ResponseEntity.created(URI.create("/api/v1/rallies/" + currentId)).build();
    }

    @ApiOperation(value = "랠리글 수정 API")
    @ApiResponses({
        @ApiResponse(code = 201, message = "[Created]"),
        @ApiResponse(code = 400, message = "[Bad Request]"),
        @ApiResponse(code = 403, message = "[Forbidden]")
    })
    @PutMapping("/rallies/{rallyId}")
    public ResponseEntity<?> modifyRally(@RequestBody RallyDTO modifyRally,
        @PathVariable int rallyId) {

        rallyService.modifyRally(modifyRally, rallyId);

        return ResponseEntity.created(URI.create("/api/v1/rallies/" + rallyId)).build();
    }

    @ApiOperation(value = "취소된 랠리글 삭제 API")
    @ApiResponses({
        @ApiResponse(code = 204, message = "[No Content]"),
        @ApiResponse(code = 400, message = "[Bad Request]")
    })
    @DeleteMapping("/rallies/{rallyId}")
    public ResponseEntity<?> removeRally(@PathVariable int rallyId) {

        rallyService.removeRally(rallyId);

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "조건에 따른 랠리 목록 조회 API")
    @ApiResponses({
        @ApiResponse(code = 204, message = "[No Content]"),
        @ApiResponse(code = 400, message = "[Bad Request]")
    })
    @GetMapping("/rallies/search")
    public ResponseEntity<ResponseMessage> findRalliesByFilter(@PageableDefault(size = 15) Pageable pageable, @RequestBody SearchFilter searchFilter) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Page<RallySimpleDTO> searchRallies = rallyService.findRallyListBySearch(pageable, searchFilter);

        PagingButtonInfo paging = Pagination.getPagingButtonInfo(searchRallies);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("searchRallies", searchRallies);
        responseMap.put("paging", paging);

        return ResponseEntity.ok().headers(headers)
            .body(new ResponseMessage(200, "개별 조회 성공", responseMap));
    }

}
