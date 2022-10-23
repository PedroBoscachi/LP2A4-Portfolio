package lp2a4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class AlunoPropertiesDAO implements AlunoDAO {

	final static Properties baseAluno = new Properties();
	
	private static void save(){
		
		try ( final FileOutputStream fos = new FileOutputStream("/tmp/baseAluno.properties") ) {
			baseAluno.store(fos, null);
			System.out.println("salvando o properties");
		} catch(Exception e) {
			e.printStackTrace();
		};
	}
	
	static {
		try ( final FileInputStream fis = new FileInputStream("/tmp/baseAluno.properties") ) {
			baseAluno.load(fis);
		} catch(Exception e) {
			e.printStackTrace();
		};
	}
	
	@Override
	public AlunoPOJO retrieve(String matricula) {
		// TODO Auto-generated method stub
		if(matricula == null) {
			return null;
		} else {
			AlunoPOJO aluno = new AlunoPOJO();
			aluno.setMatricula(matricula);
			aluno.setNome(baseAluno.getProperty("nome"));
			return aluno;
		}
	}

	@Override
	public boolean delete(String matricula) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(AlunoPOJO aluno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create(AlunoPOJO aluno) {
		// TODO Auto-generated method stub
		return false;
	}

}
