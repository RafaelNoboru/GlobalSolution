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

import br.fiap.com.global.bo.ArtigoBo;
import br.fiap.com.global.entity.Artigo;

@Path("/artigos")
public class ArtigoResource {

	private ArtigoBo artigoBo;
	
	// Listar todos
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Artigo> listar() {
		artigoBo = new ArtigoBo();
		return artigoBo.buscarArtigos();
	}

	// Cadastrar
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Artigo artigo, @Context UriInfo uriInfo) {
		artigoBo = new ArtigoBo();
		artigoBo.cadastrar(artigo);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(artigo.getId_artigo()));

		return Response.created(builder.build()).build();
	}

	// BuscarPorId
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Artigo buscarPorId(@PathParam("id") int id) {
		artigoBo = new ArtigoBo();
		return artigoBo.buscarArtigoPorId(id);
	}

	// Alterar
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterar(Artigo artigo, @PathParam("id") int id) {
		artigoBo = new ArtigoBo();
		artigoBo.atualizar(artigo);
		return Response.ok().build();
	}

	// Remover
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int id) {
		artigoBo = new ArtigoBo();
		artigoBo.excluir(id);
	}
}
