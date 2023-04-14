package com.hamhabocca.dallibocca.jwt;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtFilter extends OncePerRequestFilter {

	private static final Logger log = LoggerFactory.getLogger(OncePerRequestFilter.class);

	public static final String AUTHORIZATION_HEADER = "Auth";
	public static final String BEARER_PREFIX = "Bearer ";

	private final TokenProvider tokenProvider;

	public JwtFilter(TokenProvider tokenProvider){
		this.tokenProvider = tokenProvider;
	}

	// 실제 필터링 로직은 doFilterInternal 에 들어감
	// JWT 토큰의 인증 정보를 현재 쓰레드의 SecurityContext 에 저장하는 역할 수행
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
		FilterChain filterChain) throws ServletException, IOException {

		/* 1. Request Header 토큰 꺼내기 */
		String jwtHeader = resolveToken(request);
	}

	private String resolveToken(HttpServletRequest request) {
		String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) {
//			return bearerToken.substring(7);
		}
//		return null;
		return bearerToken;
	}
}
