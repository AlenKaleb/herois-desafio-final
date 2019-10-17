package com.stefanini.hackaton.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.hackaton.dto.JogadorDto;
import com.stefanini.hackaton.rest.exceptions.NegocioException;
import com.stefanini.hackaton.service.JogadorService;

@Path("/jogador")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JogadorApi {

	@Inject
	private JogadorService jogadorService;

	@GET
	public Response listar() {
		return Response.ok(jogadorService.listar()).build();
	}
	
	@POST
	public Response inserir(JogadorDto jogadorDTO) throws NegocioException {
		try {
			jogadorService.inserir(jogadorDTO);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return Response.ok().build();
	}
	
	
//	@Path("/autenticar")
//	@POST
//	public Response login(LoginDTO dto) throws NegocioException {
//		if (StringUtil.isBlank(dto.getAgencia())) {
//			throw new NegocioException("Agência nao informada");
//		}
//		
//		if (StringUtil.isBlank(dto.getConta())) {
//			throw new NegocioException("Conta nao informada");
//		}
//		
//		if (dto.getAgencia().equals("123") && dto.getConta().equals("123")) {
//			getHttpRequest().getSession().setAttribute("USER", dto);
//		}
//		
//		dto.setSenha(null);
//		return Response.ok(dto).build();
//	}
	
}
