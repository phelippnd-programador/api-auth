package br.com.phdigitalcode.erp_auth.domain.model.vo;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class PermissionVO implements GrantedAuthority{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String description;
	@Override
	public String getAuthority() {
		return this.description;
	}

}
