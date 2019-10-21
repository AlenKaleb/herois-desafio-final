package com.stefanini.hackaton.service;

import java.util.Random;

import javax.inject.Inject;

import com.stefanini.hackaton.dto.HeroiDto;
import com.stefanini.hackaton.dto.JogadorDto;
import com.stefanini.hackaton.entities.Batalha;
import com.stefanini.hackaton.entities.Heroi;
import com.stefanini.hackaton.parsers.HeroiParserDTO;
import com.stefanini.hackaton.parsers.JogadorParserDTO;

public class BatalhaService {

	@Inject
	private JogadorParserDTO parserJogador;
	
	@Inject
	private HeroiParserDTO parserHeroi;

	@Inject
	private Batalha batalha;
	
	public void setBatalhaMaquina(JogadorDto jogadorPrimario, HeroiDto heroiJogadorSecundario, Integer round) {
		batalha.setBatalhaMaquina(parserJogador.toEntity(jogadorPrimario), parserHeroi.toEntity(heroiJogadorSecundario), round);
	}
	
	public void setBatalhaPessoa(JogadorDto jogadorPrimario, JogadorDto jogadorSecundario, Integer round) {
		batalha.setBatalhaPessoa(parserJogador.toEntity(jogadorPrimario), parserJogador.toEntity(jogadorSecundario), round);
	}
	
	public JogadorDto getJogadorSecundario() {
		return parserJogador.toDTO(batalha.getJogadorSecundario());
	}
	
	public void setJogadorSecundario(JogadorDto jogadorSecundario) {
		batalha.setJogadorSecundario(parserJogador.toEntity(jogadorSecundario));
	}
	
	public Integer getRandom() {
		return batalha.getRandom().nextInt(249);
	}
	
	private void round() {
		
		// 1 = Jogador 1 - Sua vez de atacar
		// 2 - Jogador 2 - Sua vez de atacar
		// Vez aleatoria
		
		Integer golpeJogadorPrimario = (batalha.getJogadorPrimario().getPersonagem().getForca() + batalha.getJogadorPrimario().getPersonagem().getAtaque() + batalha.getJogadorPrimario().getPersonagem().getPoder()) * 1000;
		Integer defesaJogadorPrimario = (batalha.getJogadorPrimario().getPersonagem().getDefesa() + batalha.getJogadorPrimario().getPersonagem().getInteligencia());
		
		Integer golpeJogadorSecundario = (batalha.getJogadorSecundario().getPersonagem().getForca() + batalha.getJogadorSecundario().getPersonagem().getAtaque() + batalha.getJogadorSecundario().getPersonagem().getPoder()) * 1000;
		Integer defesaJogadorSecundario = (batalha.getJogadorSecundario().getPersonagem().getDefesa() + batalha.getJogadorSecundario().getPersonagem().getInteligencia());
		
		if(batalha.getRandom().nextInt(3) == 1) {
			Integer danoJogadorPrimario = (golpeJogadorPrimario - defesaJogadorSecundario);
			batalha.setVidaJogadorSecundario(batalha.getVidaJogadorSecundario() - danoJogadorPrimario);
		}else {
			Integer danoJogadorSecundario = (golpeJogadorSecundario - defesaJogadorPrimario);
			batalha.setVidaJogadorPrimario(batalha.getVidaJogadorPrimario() - danoJogadorSecundario);
		}
		
		batalha.getLogJogadorPrimario().put(batalha.getContRound(), "Dano de ".concat(golpeJogadorPrimario.toString()).concat("- Dano de ").concat(defesaJogadorPrimario.toString())
				.concat(" - Vida de ").concat(batalha.getVidaJogadorPrimario().toString()));
		batalha.getLogJogadorSecundario().put(batalha.getContRound(), "Dano de ".concat(golpeJogadorSecundario.toString()).concat("- Dano de ").concat(defesaJogadorSecundario.toString()).
				concat(" - Vida de ").concat(batalha.getVidaJogadorSecundario().toString()));
	}
	
	public void start() {
		do {
			round();
			
			batalha.setContRound(batalha.getContRound() - 1);
			
		}while(batalha.getContRound() > 0 || batalha.getVidaJogadorPrimario() <= 0 || batalha.getVidaJogadorSecundario() <= 0);
	}
	
	public String gerarLogJogadores(){
		
		StringBuilder log = new StringBuilder();
		
		log.append("---------------------JOGADOR---PRIMARIO--------------------");
		batalha.getLogJogadorPrimario().forEach((key, value) -> {
			log.append(value);
		});
		
		log.append("---------------------JOGADOR---SECUNDARIO--------------------");
		batalha.getLogJogadorSecundario().forEach((key, value) -> {
			log.append(value);
		});
		
		return log.toString();
	}

}
