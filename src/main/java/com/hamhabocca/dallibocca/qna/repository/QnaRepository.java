package com.hamhabocca.dallibocca.qna.repository;

import com.hamhabocca.dallibocca.qna.entity.Qna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QnaRepository extends JpaRepository<Qna, Long> {


}
