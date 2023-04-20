package com.hamhabocca.dallibocca.review.service;

import com.hamhabocca.dallibocca.review.entity.Review;
import com.hamhabocca.dallibocca.review.repository.ReviewRepository;
import com.hamhabocca.dallibocca.review.dto.ReviewDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;

    @PersistenceContext
    private EntityManager entityManager;
    private long reviewId;


    @Autowired
    public ReviewService(ReviewRepository reviewRepository, ModelMapper modelMapper) {
        this.reviewRepository = reviewRepository;
        this.modelMapper = modelMapper;
    }


    /*전체 조회*/
    public List<ReviewDTO> findAllReview(Pageable pageable) {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(review -> modelMapper.map(review, ReviewDTO.class))
            .collect(Collectors.toList());
    }

    /*일부 조회*/
//    @Transactional
    public ReviewDTO findReviewById(long reviewId) {
        Review foundReview = reviewRepository.findById(reviewId).get();
        return modelMapper.map(foundReview, ReviewDTO.class);

    }

    /*등록*/
    @Transactional
    public void registNewReviewTest(ReviewDTO newReview) {
        reviewRepository.save(modelMapper.map(newReview, Review.class));
    }


    /*삭제*/
    @Transactional
    public ReviewDTO removeReview(ReviewDTO deleteInfo, long reviewId) {

        Review foundReview = reviewRepository.findById(reviewId).get();
        reviewRepository.delete(foundReview);

        ReviewDTO reviewDTO = new ReviewDTO();

        return reviewDTO;
    }

    /*수정*/
    @Transactional
    public void modifyReview(ReviewDTO modifyInfo, long reviewId) {

        Review foundReview = reviewRepository.findById(reviewId).get();

        foundReview.setReviewTitle(modifyInfo.getReviewTitle());
        foundReview.setReviewDetail(modifyInfo.getReviewDetail());

    }
}


