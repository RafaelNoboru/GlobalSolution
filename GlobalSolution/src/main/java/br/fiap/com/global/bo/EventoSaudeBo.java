package br.fiap.com.global.bo;

import java.util.List;

import br.fiap.com.global.dao.EventoSaudeDao;
import br.fiap.com.global.entity.EventoSaude;

public class EventoSaudeBo {

	private EventoSaudeDao eventoSaudeDao;

	public void cadastrar(EventoSaude eventoSaude) {
		eventoSaudeDao = new EventoSaudeDao();
		eventoSaudeDao.inserir(eventoSaude);
	}

	public List<EventoSaude> buscarEventos() {
		eventoSaudeDao = new EventoSaudeDao();
		return eventoSaudeDao.buscarTodosEventos();
	}

	public void atualizar(EventoSaude eventoSaude) {
		eventoSaudeDao = new EventoSaudeDao();
		eventoSaudeDao.alterar(eventoSaude);
	}

	public EventoSaude buscarEventoSaudePorId(int id) {
		eventoSaudeDao = new EventoSaudeDao();
		return eventoSaudeDao.buscarPorId(id);
	}

	public void excluir(int id) {
		eventoSaudeDao = new EventoSaudeDao();
		eventoSaudeDao.excluir(id);
	}
}
