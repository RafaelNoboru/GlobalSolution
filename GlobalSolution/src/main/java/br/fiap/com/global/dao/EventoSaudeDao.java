package br.fiap.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.com.global.entity.EventoSaude;

public class EventoSaudeDao {

	private Connection conexao;

	public void inserir(EventoSaude eventoSaude) {
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		String sql = "insert into eventoSaude (id_evento, titulo, descricao, data) values(?, ?, ?, ?)";
		try {
			comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, eventoSaude.getId_evento());
			comandoSql.setString(2, eventoSaude.getTitulo());
			comandoSql.setString(3, eventoSaude.getDescricao());
			comandoSql.setDate(4, eventoSaude.getData());
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
			comandoSql = conexao.prepareStatement("delete from eventoSaude where id_evento = ?");
			comandoSql.setInt(1, id);
			comandoSql.executeUpdate();
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<EventoSaude> buscarTodosEventos() {
		List<EventoSaude> listaEventos = new ArrayList<EventoSaude>();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("select * from eventoSaude");
			ResultSet rs = comandoSql.executeQuery();
			while (rs.next()) {
				EventoSaude es = new EventoSaude();
				es.setId_evento(rs.getInt(1));
				es.setTitulo(rs.getString(2));
				es.setDescricao(rs.getString(3));
				es.setData(rs.getDate(4));
				String tipo = rs.getString(4);
				listaEventos.add(es);
			}
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaEventos;
	}

	public EventoSaude buscarPorId(int id) {
		EventoSaude es = new EventoSaude();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("Select * from eventoSaude where id_evento = ?");
			comandoSql.setInt(1, id);
			ResultSet rs = comandoSql.executeQuery();

			if (rs.next()) {
				es = new EventoSaude();
				es.setId_evento(rs.getInt(1));
				es.setTitulo(rs.getString(2));
				es.setDescricao(rs.getString(3));
				es.setData(rs.getDate(4));

			}
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return es;
	}

	public void alterar(EventoSaude eventoSaude) {
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao
					.prepareStatement("update eventoSaude set titulo = ?, descricao = ?, data = ? where id_evento = ?");
			comandoSql.setString(1, eventoSaude.getTitulo());
			comandoSql.setString(2, eventoSaude.getDescricao());
			comandoSql.setDate(3, eventoSaude.getData());
			comandoSql.setInt(4, eventoSaude.getId_evento());
			comandoSql.executeUpdate();
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
