package com.stefanini.hackaton.persistence;

import java.util.Base64;

import javax.persistence.NoResultException;

import com.stefanini.hackaton.entities.Jogador;
import com.stefanini.hackaton.rest.exceptions.NegocioException;

public class LoginDAO extends GenericDAO<Integer, Jogador> {

	public Jogador getUser(Jogador jogador) throws NegocioException {
		try {
//			System.out.println(Base64.getEncoder().encodeToString(jogador.getSenha().getBytes()));
			return getEntityManager().
			createNamedQuery("Jogador.autenticator", Jogador.class).setParameter("nickname", jogador.getNickname()).setParameter("senha", jogador.getSenha())
			.getSingleResult();	
			
		} catch (NoResultException e) {
			System.out.println(e);
			throw new NegocioException("Nenhum usuário encontrado!");
		}
	}
	
}
