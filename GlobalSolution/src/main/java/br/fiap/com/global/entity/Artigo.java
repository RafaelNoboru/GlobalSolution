package br.fiap.com.global.entity;

import java.sql.Date;

public class Artigo {

	private int id_artigo;
	private String titulo;
	private String conteudo;
	private String autor;
	private Date dataPublicacao;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	public int getId_artigo() {
		return id_artigo;
	}
	public void setId_artigo(int id_artigo) {
		this.id_artigo = id_artigo;
	}
	
	
}
