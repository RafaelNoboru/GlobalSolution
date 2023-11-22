package br.fiap.com.global.entity;

public class ReceitaSaudavel {

	private int id_receita;
	private String nome;
	private String ingredientes;
	private String passosPreparo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
	public String getPassosPreparo() {
		return passosPreparo;
	}
	public void setPassosPreparo(String passosPreparo) {
		this.passosPreparo = passosPreparo;
	}
	public int getId_receita() {
		return id_receita;
	}
	public void setId_receita(int id_receita) {
		this.id_receita = id_receita;
	}

	
}
