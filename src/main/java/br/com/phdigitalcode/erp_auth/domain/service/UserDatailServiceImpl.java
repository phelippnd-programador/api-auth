package br.com.phdigitalcode.erp_auth.domain.service;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.server.ResponseStatusException;

import br.com.phdigitalcode.erp_auth.domain.in.repository.InUserRepository;
import br.com.phdigitalcode.erp_auth.domain.model.vo.UserDatailsVO;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class UserDatailServiceImpl implements UserDetailsService{
	Logger logger = Logger.getLogger(UserDatailServiceImpl.class.getName());
	private final InUserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserDatailsVO> userDatailsVO = repository.consultaUsuario(username);
		return  userDatailsVO.orElseThrow(()-> new UsernameNotFoundException("Usuario não encontrado!"));
	}

}
