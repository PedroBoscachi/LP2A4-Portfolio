package domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FilmeDAO {
	private static FilmeDAO instance;
	protected EntityManager entityManager;

    public static FilmeDAO getInstance(){
      if (instance == null){
         instance = new FilmeDAO();
      }

      return instance;
    }

    private FilmeDAO() {
      entityManager = obterEntityManager();
    }

    private EntityManager obterEntityManager() {
     EntityManagerFactory factory =
     Persistence.createEntityManagerFactory("aula-github4");
     if (entityManager == null) {
       entityManager = factory.createEntityManager();
     }

     return entityManager;
    }

    public Filme obterFilmePorId(final int id) {
      return entityManager.find(Filme.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Filme> obterTodosFilmes() {
      return entityManager.createQuery("FROM " +
      Filme.class.getName()).getResultList();
    }

    public void salvarFilme(Filme filme) {
      try {
         entityManager.getTransaction().begin();
         entityManager.persist(filme);
         entityManager.getTransaction().commit();
      } catch (Exception ex) {
         ex.printStackTrace();
         entityManager.getTransaction().rollback();
      }
    }

    public void alterarFilme(Filme filme) {
      try {
         entityManager.getTransaction().begin();
         entityManager.merge(filme);
         entityManager.getTransaction().commit();
      } catch (Exception ex) {
         ex.printStackTrace();
         entityManager.getTransaction().rollback();
      }
    }

    public void removerFilme(Filme filme) {
      try {
         entityManager.getTransaction().begin();
         filme = entityManager.find(Filme.class, filme.getId());
         entityManager.remove(filme);
         entityManager.getTransaction().commit();
      } catch (Exception ex) {
         ex.printStackTrace();
         entityManager.getTransaction().rollback();
      }
    }

    public void removerFilmePorId(final int id) {
      try {
         Filme filme = obterFilmePorId(id);
         removerFilme(filme);
      } catch (Exception ex) {
         ex.printStackTrace();
      }
    }
}
