package com.hamhabocca.dallibocca.qna.service;

import com.hamhabocca.dallibocca.qna.dto.QnaDTO;
import com.hamhabocca.dallibocca.qna.entity.Qna;
import com.hamhabocca.dallibocca.qna.repository.QnaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class QnaService {

	private final QnaRepository qnaRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public QnaService(QnaRepository qnaRepository, ModelMapper modelMapper) {
		this.qnaRepository = qnaRepository;
		this.modelMapper = new ModelMapper();
	}

	public List<QnaDTO> findAllQna() {
		List<Qna> qnas = qnaRepository.findAllQna();
		return qnas.stream().map(qna -> modelMapper.map(qna, QnaDTO.class))
			.collect(Collectors.toList());
	}

	public List<QnaDTO> findOneQna() {
		List<Qna> qnas = qnaRepository.findOneQna();
		return qnas.stream().map(qna -> modelMapper.map(qna, QnaDTO.class))
			.collect(Collectors.toList());

	}

	@Transactional
	public void registNewQna(QnaDTO newQna) {

		qnaRepository.save(modelMapper.map(newQna, Qna.class));
	}

	@Transactional
	public QnaDTO modifyQna(QnaDTO modifyInfo) {

		// 영속화 함
		Qna foundQna = qnaRepository.findById(modifyInfo.getQnaId()).get();

		// 세터로 값 수정
		foundQna.setQnaTitle(modifyInfo.getQnaTitle());
		foundQna.setQnaId(modifyInfo.getQnaId());
		foundQna.setQnaDetail(modifyInfo.getQnaDetail());
		foundQna.setQnaWriter(modifyInfo.getQnaWriter());
		foundQna.setQnaWriteDate(modifyInfo.getQnaWriteDate());
		foundQna.setQnaCategory(modifyInfo.getQnaCategory());

		//엔티티를 dto로 변환
		QnaDTO qnaDTO = new QnaDTO();

		return qnaDTO;
	}

	@Transactional
	public QnaDTO removeQna(QnaDTO modifyInfo, int qnaId) {

		Qna foundQna = qnaRepository.findById(qnaId).get();
		qnaRepository.delete(foundQna);

		QnaDTO qnaDTO = new QnaDTO();

		return qnaDTO;
	}

}
