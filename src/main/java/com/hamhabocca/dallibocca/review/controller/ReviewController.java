package com.hamhabocca.dallibocca.review.controller;


import com.hamhabocca.dallibocca.common.ResponseMessage;
import com.hamhabocca.dallibocca.common.page.Pagination;
import com.hamhabocca.dallibocca.common.page.PagingButtonInfo;
import com.hamhabocca.dallibocca.review.dto.ReviewDTO;
import com.hamhabocca.dallibocca.review.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

@RestController
@RequestMapping("/api/v1")
public class ReviewController {
    private final ReviewService reviewService;


    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;

    }

    @ApiOperation(value = "테스트용 리뷰 추가하기")
    @PostMapping("/regists")
    public ResponseEntity<ResponseMessage> registReviewForTesting(@RequestBody ReviewDTO newReview){

        reviewService.registNewReviewTest(newReview);

        return ResponseEntity
                .created(URI.create("/api/v1/reviews" + newReview.getReviewId()))
                .build();
    }

    @ApiOperation(value = "모든 회원 목록 조회")
    @GetMapping("/reviews")
    public ResponseEntity<ResponseMessage> findAllReview(@PageableDefault(size = 15) Pageable pageable) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Map<String, Object> responseMap = new HashMap<>();


        //Page<RallySimpleDTO> reviewList = reviewService.findAllReview(pageable);
       // PagingButtonInfo paging = Pagination.getPagingButtonInfo(reviewList);


        List<ReviewDTO> reviews = reviewService.findAllReview(pageable);
        responseMap.put("reviews", reviews);

        return new ResponseEntity<>(
                new ResponseMessage(200, "조회성공", responseMap),
                headers,
                HttpStatus.OK
        );
    }

    @ApiOperation("리뷰코드로 리뷰 조회")
    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<ResponseMessage> findMenuByCode(@PathVariable Long reviewId) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        List<ReviewDTO> reviews = reviewService.findAllReview(Pageable.unpaged());

        ReviewDTO foundReview = reviews.stream().filter(review -> review.getReviewId() == reviewId).collect(Collectors.toList()).get(0);

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
    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<?> removeReview(@RequestBody ReviewDTO deleteInfo, @PathVariable Long reviewId){


        ReviewDTO foundReview = reviewService.removeReview(deleteInfo, reviewId);

        return  ResponseEntity
                .noContent()
                .build();
    }

    @ApiOperation(value = "리뷰 수정")
    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<?> modifyReview(@RequestBody ReviewDTO modifyInfo, @PathVariable Long reviewId){

        ReviewDTO foundReview = reviewService.modifyReview(modifyInfo);

        return ResponseEntity
                .created(URI.create("/api/v1/reviews" + reviewId))
                .build();
    }
}

