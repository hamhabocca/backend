package com.hamhabocca.dallibocca.login.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hamhabocca.dallibocca.jwt.TokenProvider;
import com.hamhabocca.dallibocca.login.dto.AccessTokenDTO;
import com.hamhabocca.dallibocca.login.dto.KakaoProfileDTO;
import com.hamhabocca.dallibocca.login.dto.OauthTokenDTO;
import com.hamhabocca.dallibocca.login.repository.LoginRepository;
import com.hamhabocca.dallibocca.member.dto.MemberDTO;
import com.hamhabocca.dallibocca.member.service.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {

    private final LoginRepository loginRepository;
    private final ModelMapper modelMapper;
	private final MemberService memberService;
	private final TokenProvider tokenProvider;

    @Autowired
    public LoginService(LoginRepository loginRepository, ModelMapper modelMapper,
		MemberService memberService, TokenProvider tokenProvider) {
        this.loginRepository = loginRepository;
        this.modelMapper = modelMapper;
		this.memberService = memberService;
		this.tokenProvider = tokenProvider;
	}

	public OauthTokenDTO getAccessToken(String code) {

		RestTemplate rt = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", System.getenv("KakaoRestAPIKey"));
		params.add("redirect_uri", "http://localhost:3000/oauth");
		params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
            new HttpEntity<>(params, headers);

        ResponseEntity<String> accessTokenResponse = rt.exchange(
            "https://kauth.kakao.com/oauth/token",
            HttpMethod.POST,
            kakaoTokenRequest,
            String.class
        );

		System.out.println(accessTokenResponse);
		System.out.println(accessTokenResponse.getHeaders());
		System.out.println(accessTokenResponse.getBody());

        ObjectMapper objectMapper = new ObjectMapper();
        OauthTokenDTO oauthToken = null;
        try {
            oauthToken = objectMapper.readValue(accessTokenResponse.getBody(), OauthTokenDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return oauthToken;
	}

	public KakaoProfileDTO findKakaoProfile(String accessToken) {

		RestTemplate rt = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + accessToken);
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest =
			new HttpEntity<>(headers);

		ResponseEntity<String> kakaoProfileResponse = rt.exchange(
			"https://kapi.kakao.com/v2/user/me",
			HttpMethod.POST,
			kakaoProfileRequest,
			String.class
		);

		System.out.println(kakaoProfileResponse.getBody());

		KakaoProfileDTO kakaoProfileDTO = new KakaoProfileDTO();
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			kakaoProfileDTO = objectMapper.readValue(kakaoProfileResponse.getBody(),
				KakaoProfileDTO.class);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}

		return kakaoProfileDTO;
	}

	public AccessTokenDTO getJwtToken(String accessToken) {

		KakaoProfileDTO kakaoProfileDTO = findKakaoProfile(accessToken);

		MemberDTO foundmember = new MemberDTO();

		/* 해당 유저의 가입 이력이 없을 경우 */
		if(memberService.findBySocialId("KAKAO", kakaoProfileDTO.getId()) == null) {

			MemberDTO newMember = new MemberDTO();

			newMember.setSocialLogin("KAKAO");
			newMember.setSocialId(kakaoProfileDTO.getId());
			newMember.setEmail(kakaoProfileDTO.getKakao_account().getEmail());

			if(kakaoProfileDTO.getKakao_account().getGender() != null) {
				newMember.setGender(kakaoProfileDTO.getKakao_account().getGender());
			}

			memberService.registNewUser(newMember);
		}

		/* 소셜 아이디로 멤버가 있는지 조회해 가져옴 */
		foundmember = memberService.findBySocialId("KAKAO", kakaoProfileDTO.getId());

		return tokenProvider.generateMemberTokenDTO(foundmember);
	}

}
