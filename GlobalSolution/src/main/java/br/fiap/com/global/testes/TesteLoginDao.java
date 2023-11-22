package br.fiap.com.global.testes;

import br.fiap.com.global.dao.LoginDao;
import br.fiap.com.global.entity.Login;

public class TesteLoginDao {

	public static void main(String[] args) {
		inserirLogin();

	}

	private static void inserirLogin() {
		LoginDao dao = new LoginDao();
		Login login = new Login();
		login.setId_login(1);
		login.setUsuario("usuarioTeste");
		login.setSenha("1234567");

		dao.inserir(login);

		System.out.println("Login inserido com sucesso!");
	}

}
