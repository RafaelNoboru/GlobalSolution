package br.fiap.com.global.bo;

import java.util.List;

import br.fiap.com.global.dao.AtividadeFisicaDao;
import br.fiap.com.global.entity.AtividadeFisica;

public class AtividadeFisicaBo {

	private AtividadeFisicaDao atividadeFisicaDao;

	public void cadastrar(AtividadeFisica atividadeFisica) {
		atividadeFisicaDao = new AtividadeFisicaDao();
		atividadeFisicaDao.inserir(atividadeFisica);
	}

	public List<AtividadeFisica> buscarAtividades() {
		atividadeFisicaDao = new AtividadeFisicaDao();
		return atividadeFisicaDao.buscarTodasAtividadesFisicas();
	}

	public void atualizar(AtividadeFisica atividadeFisica) {
		atividadeFisicaDao = new AtividadeFisicaDao();
		atividadeFisicaDao.alterar(atividadeFisica);
	}

	public AtividadeFisica buscarAtividadeFisicaPorId(int id) {
		atividadeFisicaDao = new AtividadeFisicaDao();
		return atividadeFisicaDao.buscarPorId(id);
	}

	public void excluir(int id) {
		atividadeFisicaDao = new AtividadeFisicaDao();
		atividadeFisicaDao.excluir(id);
	}

}
