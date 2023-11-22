package br.fiap.com.global.bo;

import java.util.List;

import br.fiap.com.global.dao.UsuarioDao;
import br.fiap.com.global.entity.Usuario;

public class UsuarioBo {

	private UsuarioDao usuarioDao;

	public void cadastrar(Usuario usuario) {
		usuarioDao = new UsuarioDao();
		usuarioDao.inserir(usuario);
	}

	public List<Usuario> buscarUsuarios() {
		usuarioDao = new UsuarioDao();
		return usuarioDao.buscarTodosUsuarios();
	}

	public void atualizar(Usuario usuario) {
		usuarioDao = new UsuarioDao();
		usuarioDao.alterar(usuario);
	}

	public Usuario buscarUsuarioPorId(int id) {
		usuarioDao = new UsuarioDao();
		return usuarioDao.buscarPorId(id);
	}

	public void excluir(int id) {
		usuarioDao = new UsuarioDao();
		usuarioDao.excluir(id);
	}
}
