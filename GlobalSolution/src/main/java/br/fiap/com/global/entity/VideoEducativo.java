package br.fiap.com.global.entity;

public class VideoEducativo {

	private int id_video;
	private String titulo;
	private String url;
	private int duracao;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public int getId_video() {
		return id_video;
	}
	public void setId_video(int id_video) {
		this.id_video = id_video;
	}
	
	
}
