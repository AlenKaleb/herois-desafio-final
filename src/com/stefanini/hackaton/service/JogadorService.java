package com.stefanini.hackaton.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.webbeans.util.StringUtil;

import com.stefanini.hackaton.dto.JogadorDto;
import com.stefanini.hackaton.parsers.JogadorParserDTO;
import com.stefanini.hackaton.persistence.JogadorDAO;
import com.stefanini.hackaton.rest.exceptions.NegocioException;

public class JogadorService {

	@Inject
	JogadorParserDTO parser;
	
	@Inject
	JogadorDAO jogadorDao;


	public List<JogadorDto> listar() {
		return parser.toDTO(jogadorDao.list());
	}
	
	public void inserir(JogadorDto jogadorDto) throws NegocioException {
		if (StringUtil.isBlank(jogadorDto.getNickname())) {
			throw new NegocioException("Nickname nao informado");
		}
		
		if (StringUtil.isBlank(jogadorDto.getSenha())) {
			throw new NegocioException("Senha nao informada");
		}
		
		if(StringUtil.isBlank(jogadorDto.getPersonagem().toString())) {
			throw new NegocioException("Personagem não foi informado");
		}
		
		jogadorDao.insert(parser.toEntity(jogadorDto));
		
	}
	
}
