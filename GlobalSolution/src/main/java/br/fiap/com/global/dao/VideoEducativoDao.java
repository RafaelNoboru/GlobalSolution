package br.fiap.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.com.global.entity.VideoEducativo;

public class VideoEducativoDao {

	private Connection conexao;

	public void inserir(VideoEducativo videoEducativo) {
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		String sql = "insert into videoEducativo (id_video, titulo, url, duracao) values(?, ?, ?, ?)";
		try {
			comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, videoEducativo.getId_video());
			comandoSql.setString(2, videoEducativo.getTitulo());
			comandoSql.setString(3, videoEducativo.getUrl());
			comandoSql.setInt(4, videoEducativo.getDuracao());
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
			comandoSql = conexao.prepareStatement("delete from videoEducativo where id_video = ?");
			comandoSql.setInt(1, id);
			comandoSql.executeUpdate();
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<VideoEducativo> buscarTodosVideos() {
		List<VideoEducativo> listaVideos = new ArrayList<VideoEducativo>();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("select * from videoEducativo");
			ResultSet rs = comandoSql.executeQuery();
			while (rs.next()) {
				VideoEducativo ve = new VideoEducativo();
				ve.setId_video(rs.getInt(1));
				ve.setTitulo(rs.getString(2));
				ve.setUrl(rs.getString(3));
				ve.setDuracao(rs.getInt(4));
				String tipo = rs.getString(4);
				listaVideos.add(ve);
			}
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaVideos;
	}

	public VideoEducativo buscarPorId(int id) {
		VideoEducativo ve = new VideoEducativo();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("Select * from videoEducativo where id_video = ?");
			comandoSql.setInt(1, id);
			ResultSet rs = comandoSql.executeQuery();

			if (rs.next()) {
				ve = new VideoEducativo();
				ve.setId_video(rs.getInt(1));
				ve.setTitulo(rs.getString(2));
				ve.setUrl(rs.getString(3));
				ve.setDuracao(rs.getInt(4));
			}
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ve;
	}

	public void alterar(VideoEducativo videoEducativo) {
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao
					.prepareStatement("update videoEducativo set titulo = ?, url = ?, duracao = ? where id_video = ?");
			comandoSql.setString(1, videoEducativo.getTitulo());
			comandoSql.setString(2, videoEducativo.getUrl());
			comandoSql.setInt(3, videoEducativo.getDuracao());
			comandoSql.setInt(4, videoEducativo.getId_video());
			comandoSql.executeUpdate();
			conexao.close();
			comandoSql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
