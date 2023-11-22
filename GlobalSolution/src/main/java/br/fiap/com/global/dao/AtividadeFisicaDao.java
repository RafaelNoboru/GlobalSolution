package br.fiap.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.com.global.entity.AtividadeFisica;

public class AtividadeFisicaDao {

	private Connection conexao;

	public void inserir(AtividadeFisica atividadeFisica) {
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		String sql = "insert into atividadeFisica (id_ativ_fisica, nome, descricao, duracaoMinutos) values(?, ?, ?, ?)";
		try {
			comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, atividadeFisica.getId_ativ_fisica());
			comandoSql.setString(2, atividadeFisica.getNome());
			comandoSql.setString(3, atividadeFisica.getDescricao());
			comandoSql.setInt(4, atividadeFisica.getDuracaoMinutos());
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
			comandoSql = conexao.prepareStatement("delete from atividadeFisica where id_ativ_fisica = ?");
			comandoSql.setInt(1, id);
			comandoSql.executeUpdate();
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<AtividadeFisica> buscarTodasAtividadesFisicas() {
		List<AtividadeFisica> listaAtividades = new ArrayList<AtividadeFisica>();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("select * from atividadeFisica");
			ResultSet rs = comandoSql.executeQuery();
			while (rs.next()) {
				AtividadeFisica af = new AtividadeFisica();
				af.setId_ativ_fisica(rs.getInt(1));
				af.setNome(rs.getString(2));
				af.setDescricao(rs.getString(3));
				af.setDuracaoMinutos(rs.getInt(4));
				String tipo = rs.getString(4);
				listaAtividades.add(af);
			}
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaAtividades;
	}

	public AtividadeFisica buscarPorId(int id) {
		AtividadeFisica af = new AtividadeFisica();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("Select * from atividadeFisica  where id_ativ_fisica = ?");
			comandoSql.setInt(1, id);
			ResultSet rs = comandoSql.executeQuery();

			if (rs.next()) {
				af = new AtividadeFisica();
				af.setId_ativ_fisica(rs.getInt(1));
				af.setNome(rs.getString(2));
				af.setDescricao(rs.getString(3));
				af.setDuracaoMinutos(rs.getInt(4));

			}
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return af;
	}

	public void alterar(AtividadeFisica atividadeFisica) {
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement(
					"update atividadeFisica set nome = ?, descricao = ?, duracaoMinutos = ? where id_ativ_fisica = ?");
			comandoSql.setString(1, atividadeFisica.getNome());
			comandoSql.setString(2, atividadeFisica.getDescricao());
			comandoSql.setInt(3, atividadeFisica.getDuracaoMinutos());
			comandoSql.setInt(4, atividadeFisica.getId_ativ_fisica());
			comandoSql.executeUpdate();
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
