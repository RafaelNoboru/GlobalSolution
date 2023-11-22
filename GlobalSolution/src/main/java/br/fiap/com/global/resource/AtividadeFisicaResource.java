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

import br.fiap.com.global.bo.AtividadeFisicaBo;
import br.fiap.com.global.entity.AtividadeFisica;

@Path("/atividades")
public class AtividadeFisicaResource {
	
	private AtividadeFisicaBo atividadeFisicaBo;

	// Listar todos
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<AtividadeFisica> listar() {
		atividadeFisicaBo = new AtividadeFisicaBo();
		return atividadeFisicaBo.buscarAtividades();
	}

	// Cadastrar
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(AtividadeFisica atividadeFisica, @Context UriInfo uriInfo) {
		atividadeFisicaBo = new AtividadeFisicaBo();
		atividadeFisicaBo.cadastrar(atividadeFisica);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(atividadeFisica.getId_ativ_fisica()));

		return Response.created(builder.build()).build();
	}

	// BuscarPorId
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public AtividadeFisica buscarPorId(@PathParam("id") int id) {
		atividadeFisicaBo = new AtividadeFisicaBo();
		return atividadeFisicaBo.buscarAtividadeFisicaPorId(id);
	}

	// Alterar
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterar(AtividadeFisica atividadeFisica, @PathParam("id") int id) {
		atividadeFisicaBo = new AtividadeFisicaBo();
		atividadeFisicaBo.atualizar(atividadeFisica);
		return Response.ok().build();
	}

	// Remover
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int id) {
		atividadeFisicaBo = new AtividadeFisicaBo();
		atividadeFisicaBo.excluir(id);
	}

}
