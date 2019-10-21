package com.stefanini.hackaton.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.hackaton.dto.JogadorDto;
import com.stefanini.hackaton.rest.exceptions.NegocioException;
import com.stefanini.hackaton.service.JogadorService;

@Path("/jogador")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JogadorApi extends BaseApi{

	@Inject
	private JogadorService jogadorService;

	@GET
	public Response listar() {
		return Response.ok(jogadorService.listar()).build();
	}

	@GET
	@Path("/listDifId/{jogadorId}")
	public Response listar(@PathParam("jogadorId") Integer id) throws NegocioException {
		return Response.ok(jogadorService.listarJogadoresDifId(id)).build();
	}
	
	@POST
	public Response inserir(JogadorDto jogadorDTO) throws NegocioException {
		jogadorService.inserir(jogadorDTO);
		return Response.ok().build();
	}
	
	@GET
	@Path("/nickname/{nickname}")
	public Response getByNickname(@PathParam("nickname") String nickname) throws NegocioException {
		return Response.ok(jogadorService.isExistNickname(nickname)).build();
	}
	
}
