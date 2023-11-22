package br.fiap.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.com.global.entity.AvaliacaoApp;
import br.fiap.com.global.entity.Usuario;

public class AvaliacaoAppDao {

	private Connection conexao;

	public void inserir(AvaliacaoApp avaliacaoApp) {
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		String sql = "insert into avaliacaoApp (id_avaliacao, classificacao, comentario, dataAvaliacao, id_usuario) values(?, ?, ?, ?, ?)";
		try {
			comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, avaliacaoApp.getId_avaliacao());
			comandoSql.setInt(2, avaliacaoApp.getClassificacao());
			comandoSql.setString(3, avaliacaoApp.getComentario());
			comandoSql.setDate(4, avaliacaoApp.getDataAvaliacao());
			comandoSql.setInt(5, avaliacaoApp.getId_usuario());
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
			comandoSql = conexao.prepareStatement("delete from avaliacaoApp where id_avaliacao = ?");
			comandoSql.setInt(1, id);
			comandoSql.executeUpdate();
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<AvaliacaoApp> buscarTodasAvaliacoes() {
		List<AvaliacaoApp> listaAvaliacoes = new ArrayList<AvaliacaoApp>();
		UsuarioDao usuarioDao = new UsuarioDao();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("select * from avaliacaoApp");
			ResultSet rs = comandoSql.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				AvaliacaoApp ava = new AvaliacaoApp();
				ava.setId_avaliacao(rs.getInt(1));
				ava.setClassificacao(rs.getInt(2));
				ava.setComentario(rs.getString(3));
				ava.setDataAvaliacao(rs.getDate(4));
				int idUsuarioAvaliacaoApp = rs.getInt(5);
				usuario = usuarioDao.buscarPorId(idUsuarioAvaliacaoApp);
				ava.setUsuario(usuario);
				String tipo = rs.getString(5);
				listaAvaliacoes.add(ava);
			}
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaAvaliacoes;
	}

	public AvaliacaoApp buscarPorId(int id) {
		UsuarioDao usuarioDao = new UsuarioDao();
		AvaliacaoApp ava = new AvaliacaoApp();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("Select * from avaliacaoApp  where id_avaliacao = ?");
			comandoSql.setInt(1, id);
			ResultSet rs = comandoSql.executeQuery();

			if (rs.next()) {
				Usuario usuario = new Usuario();
				ava = new AvaliacaoApp();
				ava.setId_avaliacao(rs.getInt(1));
				ava.setClassificacao(rs.getInt(2));
				ava.setComentario(rs.getString(3));
				ava.setDataAvaliacao(rs.getDate(4));
				int idUsuarioAvaliacaoApp = rs.getInt(5);
				usuario = usuarioDao.buscarPorId(idUsuarioAvaliacaoApp);
				ava.setUsuario(usuario);

			}
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ava;
	}

	public void alterar(AvaliacaoApp avaliacaoApp) {
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement(
					"update avaliacaoApp set classificacao = ?, comentario = ?, id_usuario=? where id_avaliacao = ?");
			comandoSql.setInt(1, avaliacaoApp.getClassificacao());
			comandoSql.setString(2, avaliacaoApp.getComentario());
			comandoSql.setInt(3, avaliacaoApp.getId_usuario());
			comandoSql.setInt(4, avaliacaoApp.getId_avaliacao());
			comandoSql.executeUpdate();
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
