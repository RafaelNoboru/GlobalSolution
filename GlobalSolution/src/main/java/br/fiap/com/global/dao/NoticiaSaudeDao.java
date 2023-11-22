package br.fiap.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.com.global.entity.NoticiaSaude;

public class NoticiaSaudeDao {

	private Connection conexao;

	public void inserir(NoticiaSaude noticiaSaude) {
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		String sql = "insert into noticiaSaude (id_noticia, manchete, descricao, fonte, dataPublicacao) values(?, ?, ?, ?, ?)";
		try {
			comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, noticiaSaude.getId_noticia());
			comandoSql.setString(2, noticiaSaude.getManchete());
			comandoSql.setString(3, noticiaSaude.getDescricao());
			comandoSql.setString(4, noticiaSaude.getFonte());
			comandoSql.setDate(5, noticiaSaude.getDataPublicacao());
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
			comandoSql = conexao.prepareStatement("delete from noticiaSaude where id_noticia = ?");
			comandoSql.setInt(1, id);
			comandoSql.executeUpdate();
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<NoticiaSaude> buscarTodasNoticias() {
		List<NoticiaSaude> listaNoticias = new ArrayList<NoticiaSaude>();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("select * from noticiaSaude");
			ResultSet rs = comandoSql.executeQuery();
			while (rs.next()) {
				NoticiaSaude ns = new NoticiaSaude();
				ns.setId_noticia(rs.getInt(1));
				ns.setManchete(rs.getString(2));
				ns.setDescricao(rs.getString(3));
				ns.setFonte(rs.getString(4));
				ns.setDataPublicacao(rs.getDate(5));
				String tipo = rs.getString(5);
				listaNoticias.add(ns);
			}
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaNoticias;
	}

	public NoticiaSaude buscarPorId(int id) {
		NoticiaSaude ns = new NoticiaSaude();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("Select * from noticiaSaude where id_noticia = ?");
			comandoSql.setInt(1, id);
			ResultSet rs = comandoSql.executeQuery();

			if (rs.next()) {
				ns = new NoticiaSaude();
				ns.setId_noticia(rs.getInt(1));
				ns.setManchete(rs.getString(2));
				ns.setDescricao(rs.getString(3));
				ns.setFonte(rs.getString(4));
				ns.setDataPublicacao(rs.getDate(5));
			}
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ns;
	}

	public void alterar(NoticiaSaude noticiaSaude) {
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement(
					"update noticiaSaude set manchete = ?, descricao = ?, fonte = ?, dataPublicacao = ? where id_noticia = ?");
			comandoSql.setString(1, noticiaSaude.getManchete());
			comandoSql.setString(2, noticiaSaude.getDescricao());
			comandoSql.setString(3, noticiaSaude.getFonte());
			comandoSql.setDate(4, noticiaSaude.getDataPublicacao());
			comandoSql.setInt(5, noticiaSaude.getId_noticia());
			comandoSql.executeUpdate();
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
