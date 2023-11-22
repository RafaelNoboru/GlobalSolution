package br.fiap.com.global.bo;

import java.util.List;

import br.fiap.com.global.dao.VideoEducativoDao;
import br.fiap.com.global.entity.VideoEducativo;

public class VideoEducativoBo {

	private VideoEducativoDao videoEducativoDao;

	public void cadastrar(VideoEducativo videoEducativo) {
		videoEducativoDao = new VideoEducativoDao();
		videoEducativoDao.inserir(videoEducativo);
	}

	public List<VideoEducativo> buscarVideos() {
		videoEducativoDao = new VideoEducativoDao();
		return videoEducativoDao.buscarTodosVideos();
	}

	public void atualizar(VideoEducativo videoEducativo) {
		videoEducativoDao = new VideoEducativoDao();
		videoEducativoDao.alterar(videoEducativo);
	}

	public VideoEducativo buscarVideoEducativoPorId(int id) {
		videoEducativoDao = new VideoEducativoDao();
		return videoEducativoDao.buscarPorId(id);
	}

	public void excluir(int id) {
		videoEducativoDao = new VideoEducativoDao();
		videoEducativoDao.excluir(id);
	}
}
