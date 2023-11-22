package br.fiap.com.global.bo;

import java.util.List;

import br.fiap.com.global.dao.DesafioSemanalDao;
import br.fiap.com.global.entity.DesafioSemanal;

public class DesafioSemanalBo {

	private DesafioSemanalDao desafioSemanalDao;

	public void cadastrar(DesafioSemanal desafioSemanal) {
		desafioSemanalDao = new DesafioSemanalDao();
		desafioSemanalDao.inserir(desafioSemanal);
	}

	public List<DesafioSemanal> buscarDesafios() {
		desafioSemanalDao = new DesafioSemanalDao();
		return desafioSemanalDao.buscarTodosDesafios();
	}

	public void atualizar(DesafioSemanal desafioSemanal) {
		desafioSemanalDao = new DesafioSemanalDao();
		desafioSemanalDao.alterar(desafioSemanal);
	}

	public DesafioSemanal buscarDesafioSemanalPorId(int id) {
		desafioSemanalDao = new DesafioSemanalDao();
		return desafioSemanalDao.buscarPorId(id);
	}

	public void excluir(int id) {
		desafioSemanalDao = new DesafioSemanalDao();
		desafioSemanalDao.excluir(id);
	}
}
