package com.stefanini.hackaton.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.webbeans.util.StringUtil;

import com.stefanini.hackaton.dto.JogadorDto;
import com.stefanini.hackaton.entities.Jogador;
import com.stefanini.hackaton.parsers.JogadorParserDTO;
import com.stefanini.hackaton.persistence.JogadorDAO;
import com.stefanini.hackaton.rest.exceptions.NegocioException;

public class JogadorService {

	@Inject
	private JogadorParserDTO parser;
	
	@Inject
	private JogadorDAO jogadorDao;


	public List<JogadorDto> listar() {
		List<JogadorDto> listaJogadorDto =  parser.toDTO(jogadorDao.list());
		return listaJogadorDto;
	}
	
	public List<JogadorDto> listarJogadoresDifId(Integer id) throws NegocioException {
		List<JogadorDto> listaJogadorDto = parser.toDTO(jogadorDao.listarJogadoresDifId(id));
		listaJogadorDto.add(0, parser.toDTO(new Jogador(0, "Maquina")));
		return listaJogadorDto;
	}
	
	public JogadorDto findByJogador(Integer id) {
		return parser.toDTO(jogadorDao.findById(id));
	}
	
	public void inserir(JogadorDto jogadorDto) throws NegocioException {
		if (StringUtil.isBlank(jogadorDto.getNickname())) {
			throw new NegocioException("Nickname nao informado");
		}
		
		if (StringUtil.isBlank(jogadorDto.getSenha())) {
			throw new NegocioException("Senha nao informada");
		}
		
		if(jogadorDto.getPersonagem() == null) {
			throw new NegocioException("Personagem não foi informado");
		}
		
		if(!StringUtil.isBlank(isExistNickname(jogadorDto.getNickname()).getNickname())) {
			throw new NegocioException("Este nickname já existe");
		}
		
		jogadorDao.insert(parser.toEntity(jogadorDto));
	}
	
	public JogadorDto isExistNickname(String nickname) throws NegocioException {
		if(StringUtil.isBlank(nickname)) {
			throw new NegocioException("Nickname nao verificado");
		}
		
		return parser.toDTO(jogadorDao.getUser(nickname));
	}
	
	
}
