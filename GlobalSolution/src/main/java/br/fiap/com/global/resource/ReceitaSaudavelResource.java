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

import br.fiap.com.global.bo.ReceitaSaudavelBo;
import br.fiap.com.global.entity.ReceitaSaudavel;

@Path("/receitas")
public class ReceitaSaudavelResource {

	private ReceitaSaudavelBo receitaSaudavelBo;

	// Listar todos
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReceitaSaudavel> listar() {
		receitaSaudavelBo = new ReceitaSaudavelBo();
		return receitaSaudavelBo.buscarReceitas();
	}

	// Cadastrar
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(ReceitaSaudavel receitaSaudavel, @Context UriInfo uriInfo) {
		receitaSaudavelBo = new ReceitaSaudavelBo();
		receitaSaudavelBo.cadastrar(receitaSaudavel);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(receitaSaudavel.getId_receita()));

		return Response.created(builder.build()).build();
	}

	// BuscarPorId
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ReceitaSaudavel buscarPorId(@PathParam("id") int id) {
		receitaSaudavelBo = new ReceitaSaudavelBo();
		return receitaSaudavelBo.buscarReceitaSaudavelPorId(id);
	}

	// Alterar
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterar(ReceitaSaudavel receitaSaudavel, @PathParam("id") int id) {
		receitaSaudavelBo = new ReceitaSaudavelBo();
		receitaSaudavelBo.atualizar(receitaSaudavel);
		return Response.ok().build();
	}

	// Remover
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int id) {
		receitaSaudavelBo = new ReceitaSaudavelBo();
		receitaSaudavelBo.excluir(id);
	}
}
