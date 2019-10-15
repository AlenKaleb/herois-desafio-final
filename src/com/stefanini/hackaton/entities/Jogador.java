package com.stefanini.hackaton.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "jogador")
@NamedQueries({ @NamedQuery(name = "Jogador.getAll", query = "SELECT j FROM Jogador j") })
public class Jogador implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	private String nickname;
	private String senha;
	
	private Heroi personagem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Heroi getPersonagem() {
		return personagem;
	}

	public void setPersonagem(Heroi personagem) {
		this.personagem = personagem;
	}
	
	
}
