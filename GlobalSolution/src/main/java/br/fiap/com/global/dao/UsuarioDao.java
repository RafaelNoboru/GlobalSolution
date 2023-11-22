package br.fiap.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.com.global.entity.Usuario;

public class UsuarioDao {

	private Connection conexao;

	public void inserir(Usuario usuario) {
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		String sql = "insert into usuario (id_usuario, nome, idade, cpf, email) values(?, ?, ?, ?, ?)";
		try {
			comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, usuario.getId_usuario());
			comandoSql.setString(2, usuario.getNome());
			comandoSql.setString(3, usuario.getIdade());
			comandoSql.setString(4, usuario.getCpf());
			comandoSql.setString(5, usuario.getEmail());
			comandoSql.executeUpdate();
			comandoSql.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void excluir(int id) {
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("delete from usuario where id_usuario = ?");
			comandoSql.setInt(1, id);
			comandoSql.executeUpdate();
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Usuario> buscarTodosUsuarios() {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("select * from usuario");
			ResultSet rs = comandoSql.executeQuery();
			while (rs.next()) {
				Usuario us = new Usuario();
				us.setId_usuario(rs.getInt(1));
				us.setNome(rs.getString(2));
				us.setIdade(rs.getString(3));
				us.setCpf(rs.getString(4));
				us.setEmail(rs.getString(5));
				String tipo = rs.getString(5);
				listaUsuarios.add(us);
			}
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaUsuarios;
	}

	public Usuario buscarPorId(int id) {
		Usuario us = new Usuario();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("Select * from usuario where id_usuario = ?");
			comandoSql.setInt(1, id);
			ResultSet rs = comandoSql.executeQuery();

			if (rs.next()) {
				us = new Usuario();
				us.setId_usuario(rs.getInt(1));
				us.setNome(rs.getString(2));
				us.setIdade(rs.getString(3));
				us.setCpf(rs.getString(4));
				us.setEmail(rs.getString(5));
			}
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return us;
	}

	public void alterar(Usuario usuario) {
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao
					.prepareStatement("update usuario set nome = ?, idade = ?, cpf = ?, email = ? where id_usuario = ?");
			comandoSql.setString(1, usuario.getNome());
			comandoSql.setString(2, usuario.getIdade());
			comandoSql.setString(3, usuario.getCpf());
			comandoSql.setString(4, usuario.getEmail());
			comandoSql.setInt(5, usuario.getId_usuario());
			comandoSql.executeUpdate();
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
