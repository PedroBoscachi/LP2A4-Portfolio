package app;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Filme;

public class Correcao {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("persistence");
		EntityManager entidade = fabrica.createEntityManager();
		List<Filme> filmes = entidade.createQuery("FROM Filme f join fetch f.diretor", Filme.class).getResultList();
	}

}
