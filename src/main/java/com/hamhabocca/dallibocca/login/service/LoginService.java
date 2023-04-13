package com.hamhabocca.dallibocca.login.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hamhabocca.dallibocca.login.dto.KakaoProfileDTO;
import com.hamhabocca.dallibocca.login.dto.OauthTokenDTO;
import com.hamhabocca.dallibocca.login.repository.LoginRepository;
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

    @Autowired
    public LoginService(LoginRepository loginRepository, ModelMapper modelMapper) {
        this.loginRepository = loginRepository;
        this.modelMapper = modelMapper;
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
//		return null;
	}

	public KakaoProfileDTO findProfile(String accessToken) {

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
}
