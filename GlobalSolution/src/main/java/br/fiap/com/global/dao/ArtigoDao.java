package br.fiap.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.com.global.entity.Artigo;

public class ArtigoDao {

	private Connection conexao;

	public void inserir(Artigo artigo) {
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		String sql = "insert into artigo (id_artigo, titulo, conteudo, autor, dataPublicacao) values(?,?, ?, ?, ?)";
		try {
			comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, artigo.getId_artigo());
			comandoSql.setString(2, artigo.getTitulo());
			comandoSql.setString(3, artigo.getConteudo());
			comandoSql.setString(4, artigo.getAutor());
			comandoSql.setDate(5, artigo.getDataPublicacao());
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
			comandoSql = conexao.prepareStatement("delete from artigo where id_artigo = ?");
			comandoSql.setInt(1, id);
			comandoSql.executeUpdate();
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Artigo> buscarTodosArtigos() {
		List<Artigo> listaArtigos = new ArrayList<Artigo>();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("select * from artigo");
			ResultSet rs = comandoSql.executeQuery();
			while (rs.next()) {
				Artigo ar = new Artigo();
				ar.setId_artigo(rs.getInt(1));
				ar.setTitulo(rs.getString(2));
				ar.setConteudo(rs.getString(3));
				ar.setAutor(rs.getString(4));
				ar.setDataPublicacao(rs.getDate(5));
				String tipo = rs.getString(5);
				listaArtigos.add(ar);
			}
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaArtigos;
	}

	public Artigo buscarPorId(int id) {
		Artigo ar = new Artigo();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("Select * from artigo  where id_artigo = ?");
			comandoSql.setInt(1, id);
			ResultSet rs = comandoSql.executeQuery();

			if (rs.next()) {
				ar = new Artigo();
				ar.setId_artigo(rs.getInt(1));
				ar.setTitulo(rs.getString(2));
				ar.setConteudo(rs.getString(3));
				ar.setAutor(rs.getString(4));
				ar.setDataPublicacao(rs.getDate(5));
			}
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ar;
	}

	public void alterar(Artigo artigo) {
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement(
					"update artigo set titulo = ?, conteudo = ?, autor = ?, dataPublicacao = ? where id_artigo = ?");
			comandoSql.setString(1, artigo.getTitulo());
			comandoSql.setString(2, artigo.getConteudo());
			comandoSql.setString(3, artigo.getAutor());
			comandoSql.setDate(4, artigo.getDataPublicacao());
			comandoSql.setInt(5, artigo.getId_artigo());
			comandoSql.executeUpdate();
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
