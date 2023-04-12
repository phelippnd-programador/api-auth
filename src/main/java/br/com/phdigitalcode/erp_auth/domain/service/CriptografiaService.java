package br.com.phdigitalcode.erp_auth.domain.service;

public interface CriptografiaService {
	String criptograva(String texto);
	String decriptograva(String texto);
}
