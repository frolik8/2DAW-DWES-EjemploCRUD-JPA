package crudjpa.modelo.beans.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the directores database table.
 * 
 */
@Entity
@Table(name="directores")
@NamedQuery(name="Directores.findAll", query="SELECT d FROM Directores d")
public class Directores implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nombre;

	private String nacionalidad;
	
	@OneToMany(mappedBy="directores", fetch=FetchType.EAGER, targetEntity=Fotograma.class)
	private List<Fotograma> fotogramas;
	
	public Directores() {
		super();
		fotogramas = new ArrayList<Fotograma>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	/**
	 * @return the fotogramas
	 */
	public List<Fotograma> getFotogramas() {
		return fotogramas;
	}

	/**
	 * @param fotogramas the fotogramas to set
	 */
	public void setFotogramas(Collection<Fotograma> fotogramas) {
		this.fotogramas = (List<Fotograma>) fotogramas;
	}
	
	public void addFotograma(Fotograma fotograma) {
		fotogramas.add(fotograma);
	}

}