package br.com.phdigitalcode.erp_auth.domain.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AcessarDto implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
}
