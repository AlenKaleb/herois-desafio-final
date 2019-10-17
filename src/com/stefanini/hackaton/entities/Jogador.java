package com.stefanini.hackaton.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.stefanini.hackaton.annotations.NotNull;


@NamedQueries({ 
	@NamedQuery(name = "Jogador.getAll", query = "SELECT j FROM Jogador j")
//	@NamedQuery(name = "Pessoa.findByCpf", 
//	query = "SELECT p FROM Pessoa p WHERE p.cpf = :cpf")
})
@Entity
@Table(name = "jogador")
public class Jogador implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String nickname;
	@NotNull
	private String senha;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idHeroi")
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
