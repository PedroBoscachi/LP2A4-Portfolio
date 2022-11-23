package app;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Filme;
import domain.FilmeDAO;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-github4");
		EntityManager em = emf.createEntityManager();

		FilmeDAO dao = FilmeDAO.getInstance();

		Scanner scn = new Scanner(System.in);
		
		int opcao = 1;

		while (opcao != 0) {
			System.out.println("=== CRUD FILMES ===");
			System.out.println("1) Adicionar Filme");
			System.out.println("2) Remover Filme");
			System.out.println("3) Alterar Filme");
			System.out.println("4) Visualizar Filmes");
			System.out.println("0) Fechar app");
			System.out.println("Escolha uma opção: ");
			opcao = scn.nextInt();
			
			switch (opcao) {
			case 0:
				break;

			case 1:
				scn.nextLine();
				System.out.println("Nome do filme: ");
				String titulo = scn.nextLine();
				System.out.println("Diretor do filme: ");
				String diretor = scn.nextLine();
				System.out.println("Personagem Principal: ");
				String personagem = scn.nextLine();
				dao.salvarFilme(new Filme(null, titulo, diretor, personagem));
				break;

			case 2:
				System.out.println("Id do filme: ");
				int id = scn.nextInt();
				dao.removerFilme(new Filme(id, null, null, null));
				break;

			case 3:
				System.out.println("Id do filme: ");
				int idParaAlterar = scn.nextInt();
				scn.nextLine();
				System.out.println("Selecione:");
				System.out.println("1) Mudar título");
				System.out.println("2) Mudar diretor");
				System.out.println("3) Mudar personagem");
				int opcaoEscolhida = scn.nextInt();
				scn.nextLine();
				Filme filmeParaAlterar = dao.obterFilmePorId(idParaAlterar);
				if (opcaoEscolhida == 1) {
					System.out.println("Título: ");
					dao.alterarFilme(filmeParaAlterar);
				} else if(opcaoEscolhida == 2) {
					System.out.println("Diretor: ");
					dao.alterarFilme(filmeParaAlterar);
				} else {
					System.out.println("Personagem: ");
					dao.alterarFilme(filmeParaAlterar);
				}
				break;

			case 4:
				for (Filme filme : dao.obterTodosFilmes()) {
					System.out.println(filme);
				}
				break;
				
			default:
				break;
			}
		}

		em.close();
		emf.close();
	}

}
