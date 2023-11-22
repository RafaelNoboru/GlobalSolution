package br.fiap.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.com.global.entity.ReceitaSaudavel;

public class ReceitaSaudavelDao {

	private Connection conexao;

	public void inserir(ReceitaSaudavel receitaSaudavel) {
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		String sql = "insert into receitaSaudavel (id_receita, nome, ingredientes, passosPreparo) values(?, ?, ?, ?)";
		try {
			comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, receitaSaudavel.getId_receita());
			comandoSql.setString(2, receitaSaudavel.getNome());
			comandoSql.setString(3, receitaSaudavel.getIngredientes());
			comandoSql.setString(4, receitaSaudavel.getPassosPreparo());
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
			comandoSql = conexao.prepareStatement("delete from receitaSaudavel where id_receita = ?");
			comandoSql.setInt(1, id);
			comandoSql.executeUpdate();
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<ReceitaSaudavel> buscarTodasReceitas() {
		List<ReceitaSaudavel> listaReceitas = new ArrayList<ReceitaSaudavel>();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("select * from receitaSaudavel");
			ResultSet rs = comandoSql.executeQuery();
			while (rs.next()) {
				ReceitaSaudavel rsa = new ReceitaSaudavel();
				rsa.setId_receita(rs.getInt(1));
				rsa.setNome(rs.getString(2));
				rsa.setIngredientes(rs.getString(3));
				rsa.setPassosPreparo(rs.getString(4));
				String tipo = rs.getString(5);
				listaReceitas.add(rsa);
			}
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaReceitas;
	}

	public ReceitaSaudavel buscarPorId(int id) {
		ReceitaSaudavel rsa = new ReceitaSaudavel();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("Select * from receitaSaudavel where id_receita = ?");
			comandoSql.setInt(1, id);
			ResultSet rs = comandoSql.executeQuery();

			if (rs.next()) {
				rsa = new ReceitaSaudavel();
				rsa.setId_receita(rs.getInt(1));
				rsa.setNome(rs.getString(2));
				rsa.setIngredientes(rs.getString(3));
				rsa.setPassosPreparo(rs.getString(4));
			}
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rsa;
	}

	public void alterar(ReceitaSaudavel receitaSaudavel) {
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement(
					"update receitaSaudavel set nome = ?, ingredientes = ?, passosPreparo = ? where id_receita = ?");
			comandoSql.setString(1, receitaSaudavel.getNome());
			comandoSql.setString(2, receitaSaudavel.getIngredientes());
			comandoSql.setString(3, receitaSaudavel.getPassosPreparo());
			comandoSql.setInt(4, receitaSaudavel.getId_receita());
			comandoSql.executeUpdate();
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
