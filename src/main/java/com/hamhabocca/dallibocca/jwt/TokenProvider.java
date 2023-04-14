package com.hamhabocca.dallibocca.jwt;

import com.hamhabocca.dallibocca.member.dto.MemberDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.hamhabocca.dallibocca.login.dto.AccessTokenDTO;

@Component
public class TokenProvider {

	private static final Logger log = LoggerFactory.getLogger(TokenProvider.class);
	private static final String AUTHORITIES_KEY = "auth";
	private static final String BEARER_TYPE = "bearer";
	private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 30;

	private final Key key;

	public TokenProvider(@Value("${jwt.secret}") String secretKey) {
		byte[] keyBytes = Decoders.BASE64URL.decode(secretKey);
		this.key = Keys.hmacShaKeyFor(keyBytes);
	}

	public AccessTokenDTO generateMemberTokenDTO(MemberDTO foundmember) {
		log.info("[TokenProvider] generateTokenDto Start ===================================");

		Claims claims = Jwts
			.claims()
			.setSubject(String.valueOf(foundmember.getMemberId()));

//		claims.put(AUTHORITIES_KEY, roles);

		long now = (new Date()).getTime();

		// Access Token 생성
		Date accessTokenExpiresIn = new Date(now + ACCESS_TOKEN_EXPIRE_TIME);
		String jwtToken = Jwts.builder()
			.setClaims(claims)
			//.claim(AUTHORITIES_KEY, roles)
			.setExpiration(accessTokenExpiresIn)
			.signWith(key, SignatureAlgorithm.HS512)
			.compact();

		return new AccessTokenDTO(BEARER_TYPE, foundmember.getMemberId(), jwtToken,
			accessTokenExpiresIn.getTime());
	}

	public Authentication getAuthentication(String accessToken) {

		/* 토큰 복호화 */
		Claims claims = parseClaims(accessToken);

		return null;
	}

	private Claims parseClaims(String accessToken) {
		try {
			return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
		} catch (ExpiredJwtException e) {
			return e.getClaims();
		}
	}
}
