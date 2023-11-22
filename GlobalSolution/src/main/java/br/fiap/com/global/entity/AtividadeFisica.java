package br.fiap.com.global.entity;

public class AtividadeFisica {

	private int id_ativ_fisica;
	private String nome;
	private String descricao;
	private int duracaoMinutos;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getDuracaoMinutos() {
		return duracaoMinutos;
	}
	public void setDuracaoMinutos(int duracaoMinutos) {
		this.duracaoMinutos = duracaoMinutos;
	}
	public int getId_ativ_fisica() {
		return id_ativ_fisica;
	}
	public void setId_ativ_fisica(int id_ativ_fisica) {
		this.id_ativ_fisica = id_ativ_fisica;
	}
	
}
