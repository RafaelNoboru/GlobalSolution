package br.fiap.com.global.bo;

import java.util.List;

import br.fiap.com.global.dao.NoticiaSaudeDao;
import br.fiap.com.global.entity.NoticiaSaude;

public class NoticiaSaudeBo {

	private NoticiaSaudeDao noticiaSaudeDao;

	public void cadastrar(NoticiaSaude noticiaSaude) {
		noticiaSaudeDao = new NoticiaSaudeDao();
		noticiaSaudeDao.inserir(noticiaSaude);
	}

	public List<NoticiaSaude> buscarNoticias() {
		noticiaSaudeDao = new NoticiaSaudeDao();
		return noticiaSaudeDao.buscarTodasNoticias();
	}

	public void atualizar(NoticiaSaude noticiaSaude) {
		noticiaSaudeDao = new NoticiaSaudeDao();
		noticiaSaudeDao.alterar(noticiaSaude);
	}

	public NoticiaSaude buscarNoticiaSaudePorId(int id) {
		noticiaSaudeDao = new NoticiaSaudeDao();
		return noticiaSaudeDao.buscarPorId(id);
	}

	public void excluir(int id) {
		noticiaSaudeDao = new NoticiaSaudeDao();
		noticiaSaudeDao.excluir(id);
	}

}
