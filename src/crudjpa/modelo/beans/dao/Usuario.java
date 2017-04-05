package crudjpa.modelo.beans.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Inheritance (strategy=InheritanceType.SINGLE_TABLE)
@Table(name="usuarios")
@DiscriminatorColumn(name="DTYPE", discriminatorType=DiscriminatorType.STRING)
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String login;

	private String clave;

	private String email;

	private String nombre;

	@OneToOne
	@JoinColumn(name="login")
	private Ranking ranking;
	
	public Usuario() {
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the ranking
	 */
	public Ranking getRanking() {
		return ranking;
	}

	/**
	 * @param ranking the ranking to set
	 */
	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}

}