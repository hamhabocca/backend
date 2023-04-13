package com.hamhabocca.dallibocca.review.repository;

import com.hamhabocca.dallibocca.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query(value = "SELECT A.REVIEW_CODE, A.REVIEW_TITLE, A.REVIEW_WRITER, A.REVIEW_DETAIL, A.REVIEW_WRITE_DATE, A.RALLY_CODE FROM REVIEW A ORDER BY A.REVIEW_CODE ASC",
            nativeQuery = true)
    List<Review> findAllReview();


}
