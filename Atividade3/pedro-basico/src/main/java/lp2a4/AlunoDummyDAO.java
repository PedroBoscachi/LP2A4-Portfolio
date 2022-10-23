package lp2a4;

public class AlunoDummyDAO implements AlunoDAO {
	@Override
	public AlunoPOJO retrieve(String matricula) {
		AlunoPOJO aluno = new AlunoPOJO();
		aluno.setMatricula(matricula);
		aluno.setNome("Rick Grimes");
		return aluno;
	}
	
	@Override
	public boolean delete(String matricula) {
		System.out.println("apagando a matrícula " + matricula);
		return true;
	}
	
	@Override
	public boolean update(AlunoPOJO aluno) {
		System.out.println("atualizando a matrícula " + aluno.getMatricula());
		return true;
	}
	
	@Override
	public boolean create(AlunoPOJO aluno) {
		System.out.println("criando aluno da matricula " + aluno.getMatricula());
		return true;
	}
}
