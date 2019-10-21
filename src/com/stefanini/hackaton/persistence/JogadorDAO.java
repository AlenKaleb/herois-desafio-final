package com.stefanini.hackaton.persistence;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import com.stefanini.hackaton.entities.Jogador;
import com.stefanini.hackaton.rest.exceptions.NegocioException;

public class JogadorDAO extends GenericDAO<Integer, Jogador>{
	
	
	public Jogador getUser(String nickname) throws NegocioException {
		
		try {
			return getEntityManager().
			 createNamedQuery("Jogador.findUserByNickname", Jogador.class).setParameter("nickname", nickname)
			.getSingleResult();	
			
		} catch (NoResultException e) {
			return new Jogador();
		}
	}
	
	public List<Jogador> listarJogadoresDifId(Integer id) throws NegocioException {
		
		try {
			return getEntityManager().
			 createNamedQuery("Jogador.findUserDifById", Jogador.class).setParameter("id", id)
			.getResultList();	
			
		} catch (NoResultException e) {
			return new ArrayList<Jogador>();
		}
	}
	
	
}
