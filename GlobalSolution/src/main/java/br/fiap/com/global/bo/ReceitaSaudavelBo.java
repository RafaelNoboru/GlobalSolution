package br.fiap.com.global.bo;

import java.util.List;

import br.fiap.com.global.dao.ReceitaSaudavelDao;

import br.fiap.com.global.entity.ReceitaSaudavel;

public class ReceitaSaudavelBo {

	private ReceitaSaudavelDao receitaSaudavelDao;

	public void cadastrar(ReceitaSaudavel receitaSaudavel) {
		receitaSaudavelDao = new ReceitaSaudavelDao();
		receitaSaudavelDao.inserir(receitaSaudavel);
	}

	public List<ReceitaSaudavel> buscarReceitas() {
		receitaSaudavelDao = new ReceitaSaudavelDao();
		return receitaSaudavelDao.buscarTodasReceitas();
	}

	public void atualizar(ReceitaSaudavel receitaSaudavel) {
		receitaSaudavelDao = new ReceitaSaudavelDao();
		receitaSaudavelDao.alterar(receitaSaudavel);
	}

	public ReceitaSaudavel buscarReceitaSaudavelPorId(int id) {
		receitaSaudavelDao = new ReceitaSaudavelDao();
		return receitaSaudavelDao.buscarPorId(id);
	}

	public void excluir(int id) {
		receitaSaudavelDao = new ReceitaSaudavelDao();
		receitaSaudavelDao.excluir(id);
	}
}
