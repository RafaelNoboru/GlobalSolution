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

import br.fiap.com.global.bo.DesafioSemanalBo;
import br.fiap.com.global.entity.DesafioSemanal;

@Path("/desafios")
public class DesafioSemanalResource {

	private DesafioSemanalBo desafioSemanalBo;
	
	// Listar todos
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DesafioSemanal> listar() {
		desafioSemanalBo = new DesafioSemanalBo();
		return desafioSemanalBo.buscarDesafios();
	}

	// Cadastrar
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(DesafioSemanal desafioSemanal, @Context UriInfo uriInfo) {
		desafioSemanalBo = new DesafioSemanalBo();
		desafioSemanalBo.cadastrar(desafioSemanal);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(desafioSemanal.getId_desafio()));

		return Response.created(builder.build()).build();
	}

	// BuscarPorId
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public DesafioSemanal buscarPorId(@PathParam("id") int id) {
		desafioSemanalBo = new DesafioSemanalBo();
		return desafioSemanalBo.buscarDesafioSemanalPorId(id);
	}

	// Alterar
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterar(DesafioSemanal desafioSemanal, @PathParam("id") int id) {
		desafioSemanalBo = new DesafioSemanalBo();
		desafioSemanalBo.atualizar(desafioSemanal);
		return Response.ok().build();
	}

	// Remover
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int id) {
		desafioSemanalBo = new DesafioSemanalBo();
		desafioSemanalBo.excluir(id);
	}
}
