package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Diretor
 *
 */
@Entity

public class Diretor implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private int id;
	@Column
	String nome;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Diretor [id=" + id + ", nome=" + nome + "]";
	}
}
