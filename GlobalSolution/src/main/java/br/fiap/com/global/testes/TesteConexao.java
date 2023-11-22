package br.fiap.com.global.testes;

import br.fiap.com.global.dao.Conexao;

public class TesteConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		if(Conexao.obterConexao() == null){
	            System.out.println("Conexão não estabelecida");
	        }
	    else {
	            System.out.println("Conexão estabelecida");
	        }

	    }

	}

