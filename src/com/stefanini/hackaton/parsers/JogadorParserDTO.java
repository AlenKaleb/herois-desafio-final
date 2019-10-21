package com.stefanini.hackaton.parsers;

import com.stefanini.hackaton.dto.JogadorDto;
import com.stefanini.hackaton.entities.Jogador;

public class JogadorParserDTO extends AbstractParser<JogadorDto, Jogador> {

	@Override
	public JogadorDto toDTO(Jogador entity) {
		JogadorDto jogadorDto = new JogadorDto();
		jogadorDto.setId(entity.getId());
		jogadorDto.setNickname(entity.getNickname());
		jogadorDto.setPersonagem(entity.getPersonagem());
		jogadorDto.setSenha(null);
		return jogadorDto;
	}

	@Override
	public Jogador toEntity(JogadorDto dto) {
		Jogador jogador = new Jogador();
		jogador.setId(dto.getId());
		jogador.setNickname(dto.getNickname());
		jogador.setPersonagem(dto.getPersonagem());
		jogador.setSenha(dto.getSenha());
		return jogador;
	}
	
}
