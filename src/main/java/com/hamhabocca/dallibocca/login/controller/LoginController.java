package com.hamhabocca.dallibocca.login.controller;

import com.hamhabocca.dallibocca.login.dto.OauthTokenDTO;
import com.hamhabocca.dallibocca.login.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "로그인 내부 API")
@RestController
@RequestMapping("/api/v1")
public class LoginController {

	private final LoginService loginService;

	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@ApiOperation(value = "카카오 인가 코드 받아와서 액세스 토큰 발급")
	@GetMapping("/kakaocode")
	public ResponseEntity<?> getKakaoCode(@Param("code") String code) {

		/* 인가 코드로 액세스 토큰 발급 */
		OauthTokenDTO oauthToken = loginService.getAccessToken(code);

		System.out.println(oauthToken.getAccess_token());

		/* 액세스 토큰으로 카카오 회원 정보 조회 */
//		loginService.saveMember(oauthToken.getAccess_token());

		return ResponseEntity
			.noContent()
			.build();
	}
}
