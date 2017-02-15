package crudjpa.modelo.beans.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ranking database table.
 * 
 */
@Entity
@Table(name="ranking")
@NamedQuery(name="Ranking.findAll", query="SELECT r FROM Ranking r")
public class Ranking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String login;

	private int puntos;

	public Ranking() {
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getPuntos() {
		return this.puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

}