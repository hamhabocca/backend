package com.hamhabocca.dallibocca.comment.repository;

import com.hamhabocca.dallibocca.comment.entity.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	@Query(value = "SELECT A.MEMBER_ID, A.NICKNAME, A.COMMENT, A.COMMENT_WRITE_DATE FROM COMMENT A ORDER BY A.MEMBER_ID ASC",
		nativeQuery = true)
	List<Comment> findAllComment();
}
