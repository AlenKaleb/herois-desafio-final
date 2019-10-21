package com.stefanini.hackaton.parsers;

import com.stefanini.hackaton.dto.LoginDto;
import com.stefanini.hackaton.entities.Jogador;

public class LoginParserDTO extends AbstractParser<LoginDto, Jogador> {

	@Override
	public LoginDto toDTO(Jogador entity) {
		LoginDto loginDto = new LoginDto();
		loginDto.setId(entity.getId());
		loginDto.setNickname(entity.getNickname());
		loginDto.setSenha(entity.getSenha());
		return loginDto;
	}

	@Override
	public Jogador toEntity(LoginDto dto) {
		Jogador jogador = new Jogador();
		jogador.setId(dto.getId());
		jogador.setNickname(dto.getNickname());
		jogador.setSenha(dto.getSenha());
		return jogador;
	}
	
}
