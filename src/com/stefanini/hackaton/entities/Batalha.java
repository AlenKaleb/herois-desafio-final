package com.stefanini.hackaton.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;

import com.stefanini.hackaton.dto.JogadorDto;

public class Batalha implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Jogador jogadorPrimario;
	
	private Jogador jogadorSecundario;
	
	private Integer contRound;
	
	private Random random;
	
	private Integer vidaJogadorPrimario;
	private Integer vidaJogadorSecundario;
	
	private HashMap<Integer, String> logJogadorPrimario;
	private HashMap<Integer, String> logJogadorSecundario;
	
	public Batalha() {
		setRandom(new Random());
	}
	
	public void setBatalhaPessoa(Jogador jogadorPrimario, Jogador jogadorSecundario, Integer round) {
		setJogadorPrimario(jogadorPrimario);
		setJogadorSecundario(jogadorSecundario);
		setContRound(round);
		setVidaJogadorPrimario(jogadorPrimario.getPersonagem().getVida());
		setVidaJogadorSecundario(jogadorSecundario.getPersonagem().getVida());
		setLogJogadorPrimario(new HashMap<Integer, String>());
		setLogJogadorSecundario(new HashMap<Integer, String>());
	}
	
	public void setBatalhaMaquina(Jogador jogadorPrimario, Heroi heroiJogadorSecundario, Integer round) {
		Jogador jogadorSecundario = new Jogador(0, "MAQUINA");
		jogadorSecundario.setPersonagem(new Heroi());
		setJogadorPrimario(jogadorPrimario);
		setJogadorSecundario(jogadorSecundario);
		getJogadorSecundario().setPersonagem(heroiJogadorSecundario);
		setContRound(round);
		setVidaJogadorPrimario(jogadorPrimario.getPersonagem().getVida());
		setVidaJogadorSecundario(jogadorSecundario.getPersonagem().getVida());
		setLogJogadorPrimario(new HashMap<Integer, String>());
		setLogJogadorSecundario(new HashMap<Integer, String>());
	}
	
	public Integer getVidaJogadorPrimario() {
		return vidaJogadorPrimario;
	}

	public void setVidaJogadorPrimario(Integer vidaJogadorPrimario) {
		this.vidaJogadorPrimario = vidaJogadorPrimario;
	}

	public Integer getVidaJogadorSecundario() {
		return vidaJogadorSecundario;
	}

	public void setVidaJogadorSecundario(Integer vidaJogadorSecundario) {
		this.vidaJogadorSecundario = vidaJogadorSecundario;
	}

	public HashMap<Integer, String> getLogJogadorPrimario() {
		return logJogadorPrimario;
	}

	public void setLogJogadorPrimario(HashMap<Integer, String> logJogadorPrimario) {
		this.logJogadorPrimario = logJogadorPrimario;
	}

	public HashMap<Integer, String> getLogJogadorSecundario() {
		return logJogadorSecundario;
	}

	public void setLogJogadorSecundario(HashMap<Integer, String> logJogadorSecundario) {
		this.logJogadorSecundario = logJogadorSecundario;
	}

	public Integer getContRound() {
		return contRound;
	}

	public void setContRound(Integer contRound) {
		this.contRound = contRound;
	}

	public Jogador getJogadorPrimario() {
		return jogadorPrimario;
	}

	public void setJogadorPrimario(Jogador jogadorPrimario) {
		this.jogadorPrimario = jogadorPrimario;
	}

	public Jogador getJogadorSecundario() {
		return jogadorSecundario;
	}

	public void setJogadorSecundario(Jogador jogadorSecundario) {
		this.jogadorSecundario = jogadorSecundario;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}
	
}
