package br.fiap.com.global.bo;

import java.util.List;

import br.fiap.com.global.dao.ArtigoDao;
import br.fiap.com.global.entity.Artigo;

public class ArtigoBo {

	private ArtigoDao artigoDao;
	private ArtigoBo artigoBo;

	public boolean validarConteudo(Artigo artigo) {

		return artigo.getConteudo().length() >= 50;
	}

	public void cadastrar(Artigo artigo) {
		artigoDao = new ArtigoDao();
		artigoBo = new ArtigoBo();
		if (artigoBo.validarConteudo(artigo)) {
			artigoDao.inserir(artigo);
		} else {
			System.out.println("Conteúdo inválido para o artigo. Não foi possível cadastrar.");
		}
	}

	public List<Artigo> buscarArtigos() {
		artigoDao = new ArtigoDao();
		return artigoDao.buscarTodosArtigos();
	}

	public void atualizar(Artigo artigo) {
		artigoDao = new ArtigoDao();
		artigoDao.alterar(artigo);
	}

	public Artigo buscarArtigoPorId(int id) {
		artigoDao = new ArtigoDao();
		return artigoDao.buscarPorId(id);
	}

	public void excluir(int id) {
		artigoDao = new ArtigoDao();
		artigoDao.excluir(id);
	}
}
