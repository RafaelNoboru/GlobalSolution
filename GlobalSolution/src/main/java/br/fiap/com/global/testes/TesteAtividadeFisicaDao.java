package br.fiap.com.global.testes;

import java.util.List;
import java.util.Scanner;

import br.fiap.com.global.dao.AtividadeFisicaDao;
import br.fiap.com.global.entity.AtividadeFisica;

public class TesteAtividadeFisicaDao {

	public static void main(String[] args) {

		Scanner numero = new Scanner(System.in);
		Scanner texto = new Scanner(System.in);

		AtividadeFisica atividadeFisica = new AtividadeFisica();

        atividadeFisica.setId_ativ_fisica(2); 
        atividadeFisica.setNome("Caminhada");
        atividadeFisica.setDescricao("Atividade de caminhada leve");
        atividadeFisica.setDuracaoMinutos(30);

		AtividadeFisicaDao dao = new AtividadeFisicaDao();
        dao.inserir(atividadeFisica);

		System.out.println("Digite um id para pesquisar:");
		int idParaBuscar = numero.nextInt();
		AtividadeFisica atividadeEncontrada = dao.buscarPorId(idParaBuscar);

		if (atividadeEncontrada != null) {
			System.out.println("Atividade Física Encontrada:");
			System.out.println("ID: " + atividadeEncontrada.getId_ativ_fisica());
			System.out.println("Nome: " + atividadeEncontrada.getNome());
			System.out.println("Descrição: " + atividadeEncontrada.getDescricao());
			System.out.println("Duração em Minutos: " + atividadeEncontrada.getDuracaoMinutos());
			
			System.out.println("Digite os novos dados da atividade:");
            System.out.println("Novo Nome: ");
            atividadeEncontrada.setNome(texto.nextLine());
            System.out.println("Nova Descrição: ");
            atividadeEncontrada.setDescricao(texto.nextLine());
            System.out.println("Nova Duração em Minutos: ");
            atividadeEncontrada.setDuracaoMinutos(numero.nextInt());

            dao.alterar(atividadeEncontrada); 
            
            System.out.println("Atividade Física Alterada com Sucesso!");

		} else {
			System.out.println("Atividade Física não encontrada.");
		}

		System.out.println("Digite um id para excluir:");
		dao.excluir(numero.nextInt());

		System.out.println("Lista de Todas as Atividades Físicas:");
		List<AtividadeFisica> todasAtividades = dao.buscarTodasAtividadesFisicas();

		for (AtividadeFisica atividade : todasAtividades) {
			System.out.println("ID: " + atividade.getId_ativ_fisica());
			System.out.println("Nome: " + atividade.getNome());
			System.out.println("Descrição: " + atividade.getDescricao());
			System.out.println("Duração em Minutos: " + atividade.getDuracaoMinutos());
			System.out.println("---------------------");
		}
	}
}    

