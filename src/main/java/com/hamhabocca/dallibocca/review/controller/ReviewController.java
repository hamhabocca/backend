package com.hamhabocca.dallibocca.review.controller;


import com.hamhabocca.dallibocca.common.ResponseMessage;
import com.hamhabocca.dallibocca.review.reviewdto.ReviewDTO;
import com.hamhabocca.dallibocca.review.service.ReviewService;
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

@RestController
@RequestMapping("/api/v1")
public class ReviewController {
    private final ReviewService reviewService;


    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;

    }

    @ApiOperation(value = "테스트용 리뷰 추가하기")
    @PostMapping("regist")
    public ResponseEntity<ResponseMessage> registReviewForTesting(@RequestBody ReviewDTO newReview){

        reviewService.registNewReviewTest(newReview);

        return ResponseEntity
                .created(URI.create("/swagger/reviews" + newReview.getReviewCode()))
                .build();
    }

    @ApiOperation(value = "모든 회원 목록 조회")
    @GetMapping("/reviews")
    public ResponseEntity<ResponseMessage> findAllReview() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Map<String, Object> responseMap = new HashMap<>();

        List<ReviewDTO> reviews = reviewService.findAllReview();
        responseMap.put("reviews", reviews);

        return new ResponseEntity<>(
                new ResponseMessage(200, "조회성공", responseMap),
                headers,
                HttpStatus.OK
        );
    }

    @ApiOperation("리뷰코드로 리뷰 조회")
    @GetMapping("/reviews/{reviewCode}")
    public ResponseEntity<ResponseMessage> findMenuByCode(@PathVariable int reviewCode) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        List<ReviewDTO> reviews = reviewService.findAllReview();

        ReviewDTO foundReview = reviews.stream().filter(review -> review.getReviewCode() == reviewCode).collect(Collectors.toList()).get(0);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("review", foundReview);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseMessage(200, "조회성공", responseMap));
    }



    @ApiOperation(value = "리뷰 삭제")
    @ApiResponses({
            @ApiResponse(code = 204, message = "리뷰 삭제 성공"),
            @ApiResponse(code = 400, message = "잘못된 파라미터")
    })
    @DeleteMapping("/reviews/{reviewCode}")
    public ResponseEntity<?> removeReview(@RequestBody ReviewDTO deleteInfo, @PathVariable int reviewCode){


        ReviewDTO foundReview = reviewService.removeReview(deleteInfo, reviewCode);

        return  ResponseEntity
                .noContent()
                .build();
    }

    @ApiOperation(value = "리뷰 수정")
    @PutMapping("/reviews/{reviewCode}")
    public ResponseEntity<?> modifyReview(@RequestBody ReviewDTO modifyInfo, @PathVariable int reviewCode){

        ReviewDTO foundReview = reviewService.modifyReview(modifyInfo);

        return ResponseEntity
                .created(URI.create("/swagger/reviews" + reviewCode))
                .build();
    }
}

