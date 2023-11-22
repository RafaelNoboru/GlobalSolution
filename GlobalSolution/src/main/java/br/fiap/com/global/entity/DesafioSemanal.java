package br.fiap.com.global.entity;

import java.sql.Date;

public class DesafioSemanal {

	private int id_desafio;
	private String descricao;
    private Date dataInicio;
    private Date dataFim;
    private String atividadesRecomendadas;
	
    public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public String getAtividadesRecomendadas() {
		return atividadesRecomendadas;
	}
	public void setAtividadesRecomendadas(String atividadesRecomendadas) {
		this.atividadesRecomendadas = atividadesRecomendadas;
	}
	public int getId_desafio() {
		return id_desafio;
	}
	public void setId_desafio(int id_desafio) {
		this.id_desafio = id_desafio;
	}
    
    
}
