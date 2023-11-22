package br.fiap.com.global.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.fiap.com.global.bo.LoginBo;
import br.fiap.com.global.entity.Login;


@Path("/login")
public class LoginResource {

	private LoginBo loginBo;
		
	// Listar todos
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Login> listar() {
		loginBo = new LoginBo();
		return loginBo.buscarLogins();
	}

	// Cadastrar
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Login login, @Context UriInfo uriInfo) {
		loginBo = new LoginBo();
		loginBo.cadastrar(login);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(login.getId_login()));

		return Response.created(builder.build()).build();
	}

	// BuscarPorId
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Login buscarPorId(@PathParam("id") int id) {
		loginBo = new LoginBo();
		return loginBo.buscarLoginPorId(id);
	}

	// Alterar
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterar(Login login, @PathParam("id") int id) {
		loginBo = new LoginBo();
		loginBo.atualizar(login);
		return Response.ok().build();
	}

	// Remover
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int id) {
		loginBo = new LoginBo();
		loginBo.excluir(id);
	}
}
