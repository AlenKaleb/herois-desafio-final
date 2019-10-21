package com.stefanini.hackaton.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.hackaton.dto.HeroiDto;
import com.stefanini.hackaton.dto.JogadorDto;
import com.stefanini.hackaton.service.BatalhaService;
import com.stefanini.hackaton.service.HeroiService;
import com.stefanini.hackaton.service.JogadorService;

@Path("/batalha")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BatalhaApi extends BaseApi{

	@Inject
	private BatalhaService batalhaService;
	
	@Inject
	private JogadorService jogadorService;
	
	@Inject
	private HeroiService heroiService;
	
	@GET
	@Path("/{idJogadorUm}/{idJogadorDois}")
	public Response batalhar(@PathParam("idJogadorUm") Integer idJogadorUm, @PathParam("idJogadorDois") Integer idJogadorDois) {
		JogadorDto jogadorPrimario = jogadorService.findByJogador(idJogadorUm);
		JogadorDto jogadorSecundario = jogadorService.findByJogador(idJogadorDois);
		batalhaService.setBatalhaPessoa(jogadorPrimario, jogadorSecundario, 10);
		batalhaService.start();
		return Response.ok(batalhaService.gerarLogJogadores()).build();
	}
	
	@GET
	@Path("/{idJogadorUm}")
	public Response batalharMaquina(@PathParam("idJogadorUm") Integer idJogadorUm) {
		JogadorDto jogadorPrimario = jogadorService.findByJogador(idJogadorUm);
		HeroiDto heroiJogadorSecundario = heroiService.findById(batalhaService.getRandom());
		batalhaService.setBatalhaMaquina(jogadorPrimario, heroiJogadorSecundario, 10);	
		batalhaService.start();
		return Response.ok(batalhaService.gerarLogJogadores()).build();
	}
	
}
