package br.fiap.com.global.entity;

import java.sql.Date;

public class NoticiaSaude {

	private int id_noticia;
	private String manchete;
	private String descricao;
	private String fonte;
	private Date dataPublicacao;
	
	public String getManchete() {
		return manchete;
	}
	public void setManchete(String manchete) {
		this.manchete = manchete;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getFonte() {
		return fonte;
	}
	public void setFonte(String fonte) {
		this.fonte = fonte;
	}
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	public int getId_noticia() {
		return id_noticia;
	}
	public void setId_noticia(int id_noticia) {
		this.id_noticia = id_noticia;
	}
	
}
