package br.com.phdigitalcode.erp_auth.domain.model.vo;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
@Getter
public class UserDatailsVO implements UserDetails {

	private static final long serialVersionUID = 1L;
	private final List<PermissionVO> permission;
	private String username;
	private String fullName;
	private String password;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	private List<String> roles;
	public UserDatailsVO(List<PermissionVO> permission) {
		this.permission =permission;
		this.roles = permission
						.parallelStream()
						.map(PermissionVO::getDescription)
						.toList();
	}
	public List<String> getRoles() {
		return roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.permission;
	}

	


}
