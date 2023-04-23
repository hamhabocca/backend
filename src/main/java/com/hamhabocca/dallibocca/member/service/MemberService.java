package com.hamhabocca.dallibocca.member.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hamhabocca.dallibocca.login.dto.KakaoProfileDTO;
import com.hamhabocca.dallibocca.member.dto.MemberDTO;
import com.hamhabocca.dallibocca.member.dto.MemberSimpleDTO;
import com.hamhabocca.dallibocca.member.entity.Member;
import com.hamhabocca.dallibocca.member.repository.MemberRepository;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class MemberService {

	private final MemberRepository memberRepository;
	private final ModelMapper modelMapper;
	private final ObjectMapper objectMapper;

	@Autowired
	public MemberService(MemberRepository memberRepository, ModelMapper modelMapper,
		ObjectMapper objectMapper) {
		this.memberRepository = memberRepository;
		this.modelMapper = modelMapper;
		this.objectMapper = objectMapper;
	}

	@Transactional
	public long registNewUser(MemberDTO newMember) {

		newMember.setNickname("새로운회원" + (Math.random() * 100 + 1));
		newMember.setLevel(1);
		newMember.setIsDeleted("N");

		return memberRepository.save(modelMapper.map(newMember, Member.class)).getMemberId();
	}

	public MemberDTO findMemberById(long memberId) {

		Member member = memberRepository.findById(memberId).get();

		return modelMapper.map(member, MemberDTO.class);
	}

	public MemberSimpleDTO findMemberByIdSimple(long memberId) {

		MemberSimpleDTO member = memberRepository.findMemberByIdSimple(memberId);

		member.setLinkToMyPage("/mypage/" + member.getMemberId());  //마이페이지 링크 기억안나서 아직 예시

		return member;
	}

	public /*List<MemberDTO>*/ Page<MemberDTO> findAllMembers(Pageable pageable) {

		pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
			pageable.getPageSize(),
			Sort.by("memberId"));

		return memberRepository.findAll(pageable)
			.map(member -> modelMapper.map(member, MemberDTO.class));
	}

	@Transactional
	public void modifyMember(MemberDTO modifyInfo, long memberId, String type) {

		Member foundMember = memberRepository.findById(memberId).get();

		switch (type) {
			case "edit":
				if (modifyInfo.getNickname().length() > 0) {
					foundMember.setNickname(modifyInfo.getNickname());
				}
				if (modifyInfo.getPreferredLocation().length() > 0) {
					foundMember.setPreferredLocation(modifyInfo.getPreferredLocation());
				}
				if (modifyInfo.getPreferredType().length() > 0) {
					foundMember.setPreferredType(modifyInfo.getPreferredType());
				}
				break;

			case "kakaodeactivate":

				RestTemplate rt = new RestTemplate();

				if(foundMember.getSocialLogin().equals("KAKAO")) {

					HttpHeaders headers = new HttpHeaders();
					headers.add("Authorization", "Bearer " + foundMember.getAccessToken());

					HttpEntity<MultiValueMap<String, String>> kakaoDeactivateRequest =
						new HttpEntity<>(headers);

					ResponseEntity<String> kakaoDeactivateResponse = rt.exchange(
						"https://kapi.kakao.com/v1/user/unlink",
						HttpMethod.POST,
						kakaoDeactivateRequest,
						String.class
					);

					System.out.println(kakaoDeactivateResponse.getBody());

					String kakaoDeactivateResult = "";

					try {
						kakaoDeactivateResult = objectMapper.readValue(
							kakaoDeactivateResponse.getBody(),
							String.class);
					} catch (JsonProcessingException e) {
						throw new RuntimeException(e);
					}

					foundMember.setIsDeleted("Y");
					break;
				} else if(foundMember.getSocialLogin().equals("NAVER")) {


				}

		}
	}

	@Transactional
	public void deleteMember(long memberId) {

		Member foundMember = memberRepository.findById(memberId).get();

		memberRepository.delete(foundMember);
	}

	public boolean checkIfRepeated(String nickname) {

		List<Member> foundMember = memberRepository.findByNickname(nickname);

		if (foundMember.size() < 1) {
			return false;
		} else {
			return true;
		}
	}

	public MemberDTO findBySocialId(String socialLogin, String socialId) {

		Member foundMember = memberRepository.findBySocialId(socialLogin, socialId);

		if (foundMember == null) {
			return null;
		} else {
			return modelMapper.map(foundMember, MemberDTO.class);
		}
	}

	public MemberDTO getAuthedMember(String header) throws JsonProcessingException {

		Map<String, String> headerMap = objectMapper.readValue(header, Map.class);

		String id = String.valueOf(headerMap.get("memberId"));

		Long memberId = Long.parseLong(id);

		System.out.println("memberId = " + memberId);
		System.out.println(memberId.getClass().getName());

		Member authedMember = memberRepository.findById(memberId).get();

		System.out.println("authedMember = " + authedMember);

		return modelMapper.map(authedMember, MemberDTO.class);
	}
}
