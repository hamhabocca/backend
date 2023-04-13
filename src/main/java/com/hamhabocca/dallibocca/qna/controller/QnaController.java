package com.hamhabocca.dallibocca.qna.controller;

import com.hamhabocca.dallibocca.common.ResponseMessage;
import com.hamhabocca.dallibocca.qna.dto.QnaDTO;
import com.hamhabocca.dallibocca.qna.service.QnaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity<ResponseMessage> findAllUQnas() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		Map<String, Object> responseMap = new HashMap<>();

		List<QnaDTO> qnas = qnaService.findAllQna();
		responseMap.put("qnas", qnas);

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
	public ResponseEntity<ResponseMessage> findQnaByNo(@PathVariable int qnaId) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		Map<String, Object> responseMap = new HashMap<>();

		List<QnaDTO> qnas = qnaService.findOneQna();

		QnaDTO foundUser = qnas.stream().filter(qna -> qna.getQnaId() == qnaId)
			.collect(Collectors.toList()).get(0);
		responseMap.put("qnas", foundUser);

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
			.created(URI.create("/swagger/qnas" + newQna.getQnaId()))
			.build();
	}

	@ApiOperation(value = "건의 수정")
	@ApiResponses({
		@ApiResponse(code = 201, message = "[Created]"),
		@ApiResponse(code = 400, message = "[Bad Request]"),
		@ApiResponse(code = 403, message = "[Forbidden]")
	})
	@PutMapping("/qnas/{qnaId}")
	public ResponseEntity<?> modifyQna(@RequestBody QnaDTO modifyInfo, @PathVariable int qnaId) {

		QnaDTO foundQna = qnaService.modifyQna(modifyInfo);

		return ResponseEntity
			.created(URI.create("/swagger/qnas" + qnaId))
			.build();
	}

	@ApiOperation(value = "건의 삭제")
	@ApiResponses({
		@ApiResponse(code = 204, message = "[No Content]"),
		@ApiResponse(code = 400, message = "[Bad Request]"),
		@ApiResponse(code = 404, message = "[Not Found]")
	})
	@DeleteMapping("/qnas/{qnaId}")
	public ResponseEntity<?> removeQna(@RequestBody QnaDTO modifyInfo, @PathVariable int qnaId) {

		QnaDTO foundQna = qnaService.removeQna(modifyInfo, qnaId);

		return ResponseEntity
			.noContent()
			.build();
	}
}
