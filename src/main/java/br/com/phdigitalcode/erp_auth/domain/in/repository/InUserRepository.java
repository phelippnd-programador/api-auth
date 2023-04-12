package br.com.phdigitalcode.erp_auth.domain.in.repository;

import java.util.Optional;

import br.com.phdigitalcode.erp_auth.domain.model.vo.UserDatailsVO;

public interface InUserRepository {

	Optional<UserDatailsVO> consultaUsuario(String username);

}
