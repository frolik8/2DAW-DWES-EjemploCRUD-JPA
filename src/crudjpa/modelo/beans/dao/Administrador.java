package crudjpa.modelo.beans.dao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
@NamedQuery(name="Administrador.findAll", query="SELECT a FROM Administrador a where TYPE(a)=Administrador")
public class Administrador extends Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int nivel;
	
	public Administrador() {
		super();
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
}
