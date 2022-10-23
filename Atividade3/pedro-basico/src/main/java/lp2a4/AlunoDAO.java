package lp2a4;

public interface AlunoDAO {

	AlunoPOJO retrieve(String matricula);

	boolean delete(String matricula);

	boolean update(AlunoPOJO aluno);

	boolean create(AlunoPOJO aluno);

}