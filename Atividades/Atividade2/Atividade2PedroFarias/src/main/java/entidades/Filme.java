package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Filme
 *
 */
@Entity

public class Filme implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private int id;
	@Column
	private String titulo;
	
	@ManyToOne
	@JoinColumn(name = "id_diretor")
	private Diretor diretor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}

	@Override
	public String toString() {
		return "Filme [id=" + id + ", titulo=" + titulo + ", diretor=" + diretor + "]";
	}
}
