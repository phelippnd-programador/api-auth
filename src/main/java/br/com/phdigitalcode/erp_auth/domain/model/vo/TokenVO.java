package br.com.phdigitalcode.erp_auth.domain.model.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TokenVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private final String username;
	private final Boolean authenticated;
	private final LocalDateTime created;
	private final LocalDateTime expiration;
	private final String accessToken;
	private final String accessRefreshToken;

}
