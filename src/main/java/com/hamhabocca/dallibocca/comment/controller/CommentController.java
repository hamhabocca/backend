package com.hamhabocca.dallibocca.comment.controller;

import com.hamhabocca.dallibocca.comment.dto.CommenetDTO;
import com.hamhabocca.dallibocca.comment.service.CommentService;
import com.hamhabocca.dallibocca.common.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Comment API")
@RestController
@RequestMapping("/api/v1/")
public class CommentController {

	private final CommentService commentService;

	@Autowired
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@ApiOperation(value = "전체 답변 조회 ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "[Ok]"),
		@ApiResponse(code = 400, message = "[Bad Request]"),
	})
	@GetMapping("/comments")
	public ResponseEntity<ResponseMessage> findAllComments() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		Map<String, Object> responseMap = new HashMap<>();

		List<CommenetDTO> comments = commentService.findAllComment();
		responseMap.put("comments", comments);

		return new ResponseEntity<>(
			new ResponseMessage(200, "조회성공", responseMap),
			headers,
			HttpStatus.OK
		);
	}

	@ApiOperation(value = "답변 작성 추가")
	@ApiResponses({
		@ApiResponse(code = 201, message = "[Created]"),
		@ApiResponse(code = 400, message = "[Bad Request]"),
		@ApiResponse(code = 403, message = "[Forbidden]")
	})
	@PostMapping("/comments")
	public ResponseEntity<?> registNewComment(@RequestBody CommenetDTO newComment) {

		commentService.registNewComment(newComment);

		return ResponseEntity
			.created(URI.create("/api/v1/comments" + newComment.getMemberId()))
			.build();

	}


}
