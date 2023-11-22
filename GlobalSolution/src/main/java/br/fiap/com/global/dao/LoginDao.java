package br.fiap.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.com.global.entity.Login;

public class LoginDao {

	private Connection conexao;

	public void inserir(Login login) {
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		String sql = "insert into login (id_login, usuario, senha) values(?, ?, ?)";
		try {
			comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, login.getId_login());
			comandoSql.setString(2, login.getUsuario());
			comandoSql.setString(3, login.getSenha());
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
			comandoSql = conexao.prepareStatement("delete from login where id_login = ?");
			comandoSql.setInt(1, id);
			comandoSql.executeUpdate();
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Login> buscarTodosLogins() {
		List<Login> listaLogins = new ArrayList<Login>();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("select * from login");
			ResultSet rs = comandoSql.executeQuery();
			while (rs.next()) {
				Login lg = new Login();
				lg.setId_login(rs.getInt(1));
				lg.setUsuario(rs.getString(2));
				lg.setSenha(rs.getString(3));
				String tipo = rs.getString(3);
				listaLogins.add(lg);
			}
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaLogins;
	}

	public Login buscarPorId(int id) {
		Login lg = new Login();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("Select * from login where id_login = ?");
			comandoSql.setInt(1, id);
			ResultSet rs = comandoSql.executeQuery();

			if (rs.next()) {
				lg = new Login();
				lg.setId_login(rs.getInt(1));
				lg.setUsuario(rs.getString(2));
				lg.setSenha(rs.getString(3));
			}
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lg;
	}

	public void alterar(Login login) {
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("update login set usuario = ?, senha = ? where id_login = ?");
			comandoSql.setString(1, login.getUsuario());
			comandoSql.setString(2, login.getSenha());
			comandoSql.setInt(3, login.getId_login());
			comandoSql.executeUpdate();
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
