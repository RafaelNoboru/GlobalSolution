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

import br.fiap.com.global.bo.NoticiaSaudeBo;
import br.fiap.com.global.entity.NoticiaSaude;

@Path("/noticias")
public class NoticiaSaudeResource {

	private NoticiaSaudeBo noticiaSaudeBo;

	// Listar todos
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<NoticiaSaude> listar() {
		noticiaSaudeBo = new NoticiaSaudeBo();
		return noticiaSaudeBo.buscarNoticias();
	}

	// Cadastrar
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(NoticiaSaude noticiaSaude, @Context UriInfo uriInfo) {
		noticiaSaudeBo = new NoticiaSaudeBo();
		noticiaSaudeBo.cadastrar(noticiaSaude);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(noticiaSaude.getId_noticia()));

		return Response.created(builder.build()).build();
	}

	// BuscarPorId
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public NoticiaSaude buscarPorId(@PathParam("id") int id) {
		noticiaSaudeBo = new NoticiaSaudeBo();
		return noticiaSaudeBo.buscarNoticiaSaudePorId(id);
	}

	// Alterar
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterar(NoticiaSaude noticiaSaude, @PathParam("id") int id) {
		noticiaSaudeBo = new NoticiaSaudeBo();
		noticiaSaudeBo.atualizar(noticiaSaude);
		return Response.ok().build();
	}

	// Remover
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int id) {
		noticiaSaudeBo = new NoticiaSaudeBo();
		noticiaSaudeBo.excluir(id);
	}
}
