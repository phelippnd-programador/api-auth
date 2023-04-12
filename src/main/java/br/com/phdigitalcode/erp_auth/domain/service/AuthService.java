package br.com.phdigitalcode.erp_auth.domain.service;

import br.com.phdigitalcode.erp_auth.domain.dto.AcessarDto;
import br.com.phdigitalcode.erp_auth.domain.model.vo.TokenVO;

public interface AuthService {
	TokenVO gerarToken(AcessarDto acesso);
	void validarToken(TokenVO token);
	void validaAcesso(AcessarDto acesso);
	void cadastrarAuth(AcessarDto acesso);
}
