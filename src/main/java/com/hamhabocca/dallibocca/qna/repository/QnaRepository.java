package com.hamhabocca.dallibocca.qna.repository;

import com.hamhabocca.dallibocca.qna.entity.Qna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QnaRepository extends JpaRepository<Qna, Integer> {

	@Query(value = "SELECT A.QNA_ID, A.QNA_DETAIL, A.QNA_TITLE, A.QNA_WRITE_DATE, A.QNA_WRITER, A.QNA_CATEGORY FROM QNA A ORDER BY A.QNA_ID ASC",
		nativeQuery = true)
	List<Qna> findAllQna();

	@Query(value = "SELECT A.QNA_ID, A.QNA_DETAIL, A.QNA_TITLE, A.QNA_WRITE_DATE, A.QNA_WRITER, A.QNA_CATEGORY FROM QNA A ORDER BY A.QNA_ID ASC",
		nativeQuery = true)
	List<Qna> findOneQna();

}
