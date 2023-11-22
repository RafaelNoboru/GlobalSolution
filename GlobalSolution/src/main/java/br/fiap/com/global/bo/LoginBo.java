package br.fiap.com.global.bo;

import java.util.List;

import br.fiap.com.global.dao.LoginDao;
import br.fiap.com.global.entity.Login;

public class LoginBo {

	private LoginDao loginDao;
	private LoginBo loginBo;

	public boolean validarSenha(String senha) {

		return senha.length() >= 8;
	}

	public void cadastrar(Login login) {
		loginDao = new LoginDao();
		loginBo = new LoginBo();
		if (loginBo.validarSenha(login.getSenha())) {
			loginDao.inserir(login);
		} else {
			System.out.println("Senha inválida. Não foi possível cadastrar o login.");
		}
	}

	public List<Login> buscarLogins() {
		loginDao = new LoginDao();
		return loginDao.buscarTodosLogins();
	}

	public void atualizar(Login login) {
		loginDao = new LoginDao();
		loginBo = new LoginBo();
		if (loginBo.validarSenha(login.getSenha())) {
			loginDao.alterar(login);
		} else {
			System.out.println("Senha inválida. Não foi possível atualizar o login.");
		}
	}

	public Login buscarLoginPorId(int id) {
		loginDao = new LoginDao();
		return loginDao.buscarPorId(id);
	}

	public void excluir(int id) {
		loginDao = new LoginDao();
		loginDao.excluir(id);
	}
}
