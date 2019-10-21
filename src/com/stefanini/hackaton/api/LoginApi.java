package com.stefanini.hackaton.api;

import java.util.Base64;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.hackaton.dto.JogadorDto;
import com.stefanini.hackaton.dto.LoginDto;
import com.stefanini.hackaton.entities.Jogador;
import com.stefanini.hackaton.rest.exceptions.NegocioException;
import com.stefanini.hackaton.service.LoginService;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginApi extends BaseApi {
	
	@Inject
	private LoginService loginService;
	
	@POST
	@Path("/auth")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response autenticar(LoginDto loginDto) throws NegocioException {
		Jogador jogador = new Jogador();
		jogador = loginService.validarUsuario(loginDto);
		if(jogador != null) {
			getHttpRequest().getSession().setAttribute("USER", loginDto);
		}
		jogador.setSenha(null);
		return Response.ok(loginDto).build();
	}
	
	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserSession() {
		return Response.ok(getHttpRequest().getSession().getAttribute("USER")).build();
	}
	
	@GET
	@Path("/logout")
	public Response logout() {
		getHttpRequest().getSession().removeAttribute("USER");
		return Response.ok().build();
	}
	
}
