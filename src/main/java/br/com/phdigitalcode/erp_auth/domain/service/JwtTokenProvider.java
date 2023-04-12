package br.com.phdigitalcode.erp_auth.domain.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import br.com.phdigitalcode.erp_auth.domain.model.vo.TokenVO;
import jakarta.servlet.http.HttpServletRequest;

public interface JwtTokenProvider {

	TokenVO createAcessToken(String username, List<String> roles, String secret);
	Authentication getAuthentication(String token);
	boolean validaToken(String token) ;
		
	public default Optional<String> resolverToken(HttpServletRequest req) {
		String authorization = req.getHeader(HttpHeaders.AUTHORIZATION);
		if(authorization!=null && authorization.startsWith("Bearer ")) {
			 String token = authorization.substring("Bearer ".length());
			 return Optional.of(token);
		}
		return Optional.empty();
	}
	public default String getToken(String username, List<String> roles, LocalDateTime now, 
				LocalDateTime validity,Algorithm algorithm,String url) {
		return JWT.create()
					.withClaim("roles", roles)
					.withIssuedAt(now.atZone(ZoneId.systemDefault()).toInstant())
					.withExpiresAt(validity.atZone(ZoneId.systemDefault()).toInstant())
					.withSubject(username)
					.withIssuer(url)
					.sign(algorithm)
					.strip();
	}
	 default DecodedJWT decodeToken(String token,Algorithm algorithm) {
		 JWTVerifier jwtVerifier=JWT.require(algorithm).build();
		 return jwtVerifier.verify(token);
	}

}
