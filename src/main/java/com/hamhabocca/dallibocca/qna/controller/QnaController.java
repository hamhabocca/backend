package com.hamhabocca.dallibocca.qna.controller;

import com.hamhabocca.dallibocca.common.ResponseMessage;
import com.hamhabocca.dallibocca.common.page.Pagination;
import com.hamhabocca.dallibocca.common.page.PagingButtonInfo;
import com.hamhabocca.dallibocca.qna.dto.QnaDTO;
import com.hamhabocca.dallibocca.qna.dto.QnaSimpleDTO;
import com.hamhabocca.dallibocca.qna.service.QnaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags = "Qna API")
@RestController
@RequestMapping("/api/v1/")
public class QnaController {

	private final QnaService qnaService;

	@Autowired
	public QnaController(QnaService qnaService) {
		this.qnaService = qnaService;
	}

	@ApiOperation(value = "모든 건의 목록 조회")
	@ApiResponses({
		@ApiResponse(code = 200, message = "[Ok]"),
		@ApiResponse(code = 400, message = "[Bad Reuest]")
	})
	@GetMapping("/qnas")
	public ResponseEntity<ResponseMessage> findQnaList(@PageableDefault Pageable pageable) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		Page<QnaSimpleDTO> qnaList = qnaService.findQnaList(pageable);

		PagingButtonInfo paging = Pagination.getPagingButtonInfo(qnaList);

		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("QnaList", qnaList) ;
		responseMap.put("paging", paging);

		return new ResponseEntity<>(
			new ResponseMessage(200, "조회성공", responseMap),
			headers,
			HttpStatus.OK
		);
	}

	@ApiOperation(value = "건의 번호로 건의 조회")
	@ApiResponses({
		@ApiResponse(code = 200, message = "[Ok]"),
		@ApiResponse(code = 400, message = "[Bad Reuest]")
	})
	@GetMapping("/qnas/{qnaId}")
	public ResponseEntity<ResponseMessage> findQnaById(@PathVariable long qnaId) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		QnaDTO foundQna = qnaService.findQnaById(qnaId);

		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("qnas", foundQna);

		return ResponseEntity
			.ok()
			.headers(headers)
			.body(new ResponseMessage(200, "조회성공", responseMap));
	}

	@ApiOperation(value = "신규 건의 추가")
	@ApiResponses({
		@ApiResponse(code = 201, message = "[Created]"),
		@ApiResponse(code = 400, message = "[Bad Request]"),
		@ApiResponse(code = 403, message = "[Forbidden]")
	})
	@PostMapping("/qnas")
	public ResponseEntity<?> registNewQna(@RequestBody QnaDTO newQna) {

		qnaService.registNewQna(newQna);

		return ResponseEntity
			.created(URI.create("/api/v1/qnas" + newQna.getQnaId()))
			.build();
	}

	@ApiOperation(value = "건의 수정")
	@ApiResponses({
		@ApiResponse(code = 201, message = "[Created]"),
		@ApiResponse(code = 400, message = "[Bad Request]"),
		@ApiResponse(code = 403, message = "[Forbidden]")
	})
	@PutMapping("/qnas/{qnaId}")
	public ResponseEntity<?> modifyQna(@RequestBody QnaDTO modifyInfo, @PathVariable long qnaId) {

		qnaService.modifyQna(modifyInfo);

		return ResponseEntity
			.created(URI.create("/api/v1/qnas" + qnaId))
			.build();
	}

	@ApiOperation(value = "건의 삭제")
	@ApiResponses({
		@ApiResponse(code = 204, message = "[No Content]"),
		@ApiResponse(code = 400, message = "[Bad Request]"),
		@ApiResponse(code = 404, message = "[Not Found]")
	})
	@DeleteMapping("/qnas/{qnaId}")
	public ResponseEntity<?> removeQna(@RequestBody QnaDTO modifyInfo, @PathVariable long qnaId) {

		qnaService.removeQna(modifyInfo, qnaId);

		return ResponseEntity
			.noContent()
			.build();
	}
}
