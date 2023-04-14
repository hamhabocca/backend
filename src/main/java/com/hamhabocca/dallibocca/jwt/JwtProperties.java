package com.hamhabocca.dallibocca.jwt;

public interface JwtProperties {

	String SECRET = System.getenv("JwtSecret");
	int EXPIRATION_TIME = 1000 * 60 * 30;
	String TOKEN_PREFIX = "Bearer ";
	String HEADER_STRING = "Auth";
}
