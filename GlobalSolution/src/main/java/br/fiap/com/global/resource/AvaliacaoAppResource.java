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

import br.fiap.com.global.bo.AvaliacaoAppBo;
import br.fiap.com.global.entity.AvaliacaoApp;

@Path("/avaliacoes")
public class AvaliacaoAppResource {

	private AvaliacaoAppBo avaliacaoAppBo;

	// Listar todos
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<AvaliacaoApp> listar() {
		avaliacaoAppBo = new AvaliacaoAppBo();
		return avaliacaoAppBo.buscarAvaliacoes();
	}

	// Cadastrar
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(AvaliacaoApp avaliacaoApp, @Context UriInfo uriInfo) {
		avaliacaoAppBo = new AvaliacaoAppBo();
		avaliacaoAppBo.cadastrar(avaliacaoApp);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(avaliacaoApp.getId_avaliacao()));

		return Response.created(builder.build()).build();
	}

	// BuscarPorId
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public AvaliacaoApp buscarPorId(@PathParam("id") int id) {
		avaliacaoAppBo = new AvaliacaoAppBo();
		return avaliacaoAppBo.buscarAvaliacaoAppPorId(id);
	}

	// Alterar
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterar(AvaliacaoApp avaliacaoApp, @PathParam("id") int id) {
		avaliacaoAppBo = new AvaliacaoAppBo();
		avaliacaoAppBo.atualizar(avaliacaoApp);
		return Response.ok().build();
	}

	// Remover
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int id) {
		avaliacaoAppBo = new AvaliacaoAppBo();
		avaliacaoAppBo.excluir(id);
	}

}
