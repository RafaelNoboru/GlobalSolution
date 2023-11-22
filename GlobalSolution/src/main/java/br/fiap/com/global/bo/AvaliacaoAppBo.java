package br.fiap.com.global.bo;

import java.util.List;

import br.fiap.com.global.dao.AvaliacaoAppDao;
import br.fiap.com.global.entity.AvaliacaoApp;

public class AvaliacaoAppBo {

	private AvaliacaoAppDao avaliacaoAppDao;
	private AvaliacaoAppBo avaliacaoAppBo;

	public boolean validarClassificacao(AvaliacaoApp avaliacao) {

		int classificacao = avaliacao.getClassificacao();
		return classificacao >= 1 && classificacao <= 5;
	}

	public void cadastrar(AvaliacaoApp avaliacaoApp) {
		avaliacaoAppDao = new AvaliacaoAppDao();
		avaliacaoAppBo = new AvaliacaoAppBo();
		if (avaliacaoAppBo.validarClassificacao(avaliacaoApp)) {
			avaliacaoAppDao.inserir(avaliacaoApp);
		} else {
			System.out.println("Classificação inválida. Não foi possível cadastrar a avaliação.");
		}
	}

	public List<AvaliacaoApp> buscarAvaliacoes() {
		avaliacaoAppDao = new AvaliacaoAppDao();
		return avaliacaoAppDao.buscarTodasAvaliacoes();
	}

	public void atualizar(AvaliacaoApp avaliacaoApp) {
		avaliacaoAppDao = new AvaliacaoAppDao();
		avaliacaoAppBo = new AvaliacaoAppBo();
		if (avaliacaoAppBo.validarClassificacao(avaliacaoApp)) {
			avaliacaoAppDao.alterar(avaliacaoApp);
		} else {
			System.out.println("Classificação inválida. Não foi possível atualizar a avaliação.");
		}
	}

	public AvaliacaoApp buscarAvaliacaoAppPorId(int id) {
		avaliacaoAppDao = new AvaliacaoAppDao();
		return avaliacaoAppDao.buscarPorId(id);
	}

	public void excluir(int id) {
		avaliacaoAppDao = new AvaliacaoAppDao();
		avaliacaoAppDao.excluir(id);
	}
}
