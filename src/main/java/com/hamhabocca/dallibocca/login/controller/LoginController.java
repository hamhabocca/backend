package com.hamhabocca.dallibocca.login.controller;

import com.hamhabocca.dallibocca.common.ResponseMessage;
import com.hamhabocca.dallibocca.jwt.JwtProperties;
import com.hamhabocca.dallibocca.login.dto.AccessTokenDTO;
import com.hamhabocca.dallibocca.login.dto.OauthTokenDTO;
import com.hamhabocca.dallibocca.login.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "로그인 내부 API")
@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

	private final LoginService loginService;

	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@ApiOperation(value = "카카오 인가 코드 받아와서 액세스 토큰 발급")
	@PostMapping("/kakaocode")
	public ResponseEntity<?> getKakaoCode(@RequestBody Map<String, String> code) {

		System.out.println("코드 받아서 백엔드 시작됨");
		System.out.println("code = " + code.get("code"));

		System.out.println("Testttttttttttttttttttttttttttttttttttttttt");

		/* 인가 코드로 액세스 토큰 발급 */
		OauthTokenDTO oauthToken = loginService.getAccessToken(code.get("code"));

		System.out.println(oauthToken.getAccess_token());

		/* 액세스 토큰으로 DB 저장or 확인 후 JWT 생성 */
		AccessTokenDTO jwtToken = loginService.getJwtToken(oauthToken.getAccess_token());

		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("token", jwtToken);

		/* JWT와 응답 결과를 프론트에 전달*/
		return ResponseEntity
				.ok()
//			.headers(headers)
				.body(new ResponseMessage(200, "로그인 성공", responseMap));
	}
}
