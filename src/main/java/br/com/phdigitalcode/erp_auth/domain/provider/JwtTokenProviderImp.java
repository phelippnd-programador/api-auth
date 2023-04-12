package br.com.phdigitalcode.erp_auth.domain.provider;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import br.com.phdigitalcode.erp_auth.domain.model.vo.TokenVO;
import br.com.phdigitalcode.erp_auth.domain.model.vo.UserDatailsVO;
import br.com.phdigitalcode.erp_auth.domain.service.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class JwtTokenProviderImp implements JwtTokenProvider{
	private final UserDetailsService userDetailsService;
	private final Algorithm algorithm;
	@Override
	public TokenVO createAcessToken(String username,List<String>roles,String secret) {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime validity = LocalDateTime.now().plusSeconds(3600);
		var accessToken = getAccessToken(username,roles,now,validity,this.algorithm);
		var refreshToken = getRefreshToken(username,roles,now,this.algorithm);
		return new TokenVO(username,true,now,validity,accessToken,refreshToken);
	}
	
	private String getRefreshToken(String username, List<String> roles, LocalDateTime now,Algorithm algorithm ) {
		LocalDateTime validityRefreshToken = LocalDateTime.now().plusHours(3);
		return getToken(username, roles, now,validityRefreshToken, algorithm,"");
	}
	private String getAccessToken(String username, List<String> roles, LocalDateTime now, LocalDateTime validity,Algorithm algorithm) {
		 return getToken(username, roles, now,validity, algorithm,"");
	}	
	@Override
	public Authentication getAuthentication(String token) {
		DecodedJWT decodedJWT = decodeToken(token,algorithm);
		UserDatailsVO userDetails= (UserDatailsVO)userDetailsService.loadUserByUsername(decodedJWT.getSubject());
		return new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
	}

	@Override
	public boolean validaToken(String token) {
		DecodedJWT decodeToken = decodeToken(token, algorithm);
		return true;
	}
}
