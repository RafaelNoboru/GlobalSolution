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

import br.fiap.com.global.bo.EventoSaudeBo;
import br.fiap.com.global.entity.EventoSaude;

@Path("/eventos")
public class EventoSaudeResource {

	private EventoSaudeBo eventoSaudeBo;
			
	// Listar todos
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EventoSaude> listar() {
		eventoSaudeBo = new EventoSaudeBo();
		return eventoSaudeBo.buscarEventos();
	}

	// Cadastrar
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(EventoSaude eventoSaude, @Context UriInfo uriInfo) {
		eventoSaudeBo = new EventoSaudeBo();
		eventoSaudeBo.cadastrar(eventoSaude);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(eventoSaude.getId_evento()));

		return Response.created(builder.build()).build();
	}

	// BuscarPorId
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public EventoSaude buscarPorId(@PathParam("id") int id) {
		eventoSaudeBo = new EventoSaudeBo();
		return eventoSaudeBo.buscarEventoSaudePorId(id);
	}

	// Alterar
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterar(EventoSaude eventoSaude, @PathParam("id") int id) {
		eventoSaudeBo = new EventoSaudeBo();
		eventoSaudeBo.atualizar(eventoSaude);
		return Response.ok().build();
	}

	// Remover
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int id) {
		eventoSaudeBo = new EventoSaudeBo();
		eventoSaudeBo.excluir(id);
	}
}
