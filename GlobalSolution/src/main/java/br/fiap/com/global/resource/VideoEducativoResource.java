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

import br.fiap.com.global.bo.VideoEducativoBo;
import br.fiap.com.global.entity.VideoEducativo;

@Path("/videos")
public class VideoEducativoResource {

	private VideoEducativoBo videoEducativoBo;

	// Listar todos
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VideoEducativo> listar() {
		videoEducativoBo = new VideoEducativoBo();
		return videoEducativoBo.buscarVideos();
	}

	// Cadastrar
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(VideoEducativo videoEducativo, @Context UriInfo uriInfo) {
		videoEducativoBo = new VideoEducativoBo();
		videoEducativoBo.cadastrar(videoEducativo);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(videoEducativo.getId_video()));

		return Response.created(builder.build()).build();
	}

	// BuscarPorId
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public VideoEducativo buscarPorId(@PathParam("id") int id) {
		videoEducativoBo = new VideoEducativoBo();
		return videoEducativoBo.buscarVideoEducativoPorId(id);
	}

	// Alterar
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterar(VideoEducativo videoEducativo, @PathParam("id") int id) {
		videoEducativoBo = new VideoEducativoBo();
		videoEducativoBo.atualizar(videoEducativo);
		return Response.ok().build();
	}

	// Remover
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int id) {
		videoEducativoBo = new VideoEducativoBo();
	}
}
