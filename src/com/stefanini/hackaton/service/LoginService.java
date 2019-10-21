package com.stefanini.hackaton.service;

import javax.inject.Inject;

import org.apache.webbeans.util.StringUtil;

import com.stefanini.hackaton.dto.LoginDto;
import com.stefanini.hackaton.entities.Jogador;
import com.stefanini.hackaton.parsers.LoginParserDTO;
import com.stefanini.hackaton.persistence.LoginDAO;
import com.stefanini.hackaton.rest.exceptions.NegocioException;

public class LoginService {

	@Inject
	private LoginParserDTO parser;
	
	@Inject
	private LoginDAO loginDao;
	
	public Jogador validarUsuario(LoginDto loginDto) throws NegocioException {
		
		if (StringUtil.isBlank(loginDto.getNickname())) {
			throw new NegocioException("Nickname nao informado");
		}
		
		if (StringUtil.isBlank(loginDto.getSenha())) {
			throw new NegocioException("Senha nao informada");
		}
		
		return loginDao.getUser(parser.toEntity(loginDto));
	}
	
}
