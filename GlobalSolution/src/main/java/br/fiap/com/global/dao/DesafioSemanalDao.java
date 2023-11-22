package br.fiap.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.com.global.entity.DesafioSemanal;

public class DesafioSemanalDao {

	private Connection conexao;

	public void inserir(DesafioSemanal desafioSemanal) {
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;

		String sql = "insert into desafioSemanal (id_desafio, descricao, dataInicio, dataFim, atividadesRecomentadas) values(?, ?, ?, ?)";
		try {
			comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, desafioSemanal.getId_desafio());
			comandoSql.setString(2, desafioSemanal.getDescricao());
			comandoSql.setDate(3, desafioSemanal.getDataInicio());
			comandoSql.setDate(4, desafioSemanal.getDataFim());
			comandoSql.setString(5, desafioSemanal.getAtividadesRecomendadas());
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
			comandoSql = conexao.prepareStatement("delete from desafioSemanal where id_desafio = ?");
			comandoSql.setInt(1, id);
			comandoSql.executeUpdate();
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<DesafioSemanal> buscarTodosDesafios() {
		List<DesafioSemanal> listaDesafios = new ArrayList<DesafioSemanal>();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("select * from desafioSemanal");
			ResultSet rs = comandoSql.executeQuery();
			while (rs.next()) {
				DesafioSemanal ds = new DesafioSemanal();
				ds.setId_desafio(rs.getInt(1));
				ds.setDescricao(rs.getString(2));
				ds.setDataInicio(rs.getDate(3));
				ds.setDataFim(rs.getDate(4));
				ds.setAtividadesRecomendadas(rs.getString(5));
				String tipo = rs.getString(5);
				listaDesafios.add(ds);
			}
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaDesafios;
	}

	public DesafioSemanal buscarPorId(int id) {
		DesafioSemanal ds = new DesafioSemanal();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("Select * from desafioSemanal  where id_desafio = ?");
			comandoSql.setInt(1, id);
			ResultSet rs = comandoSql.executeQuery();

			if (rs.next()) {
				ds = new DesafioSemanal();
				ds.setId_desafio(rs.getInt(1));
				ds.setDescricao(rs.getString(2));
				ds.setDataInicio(rs.getDate(3));
				ds.setDataFim(rs.getDate(4));
				ds.setAtividadesRecomendadas(rs.getString(5));
			}
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	public void alterar(DesafioSemanal desafioSemanal) {
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement(
					"update desafioSemanal set descricao = ?, dataInicio = ?, dataFim = ?, atividadesRecomendadas = ? where id_desafio = ?");
			comandoSql.setString(1, desafioSemanal.getDescricao());
			comandoSql.setDate(2, desafioSemanal.getDataInicio());
			comandoSql.setDate(3, desafioSemanal.getDataFim());
			comandoSql.setString(4, desafioSemanal.getAtividadesRecomendadas());
			comandoSql.setInt(5, desafioSemanal.getId_desafio());
			comandoSql.executeUpdate();
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
