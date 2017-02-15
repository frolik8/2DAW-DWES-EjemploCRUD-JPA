package crudjpa.modelo.beans.dao;

import java.util.List;

public interface DAO {
	public boolean insert(Object entidad);
	public Genero getGenero(String id);
	public boolean updateUsuario(Usuario usuario);
	public boolean removeUsuario(String login);
	public List<Fotograma> getFotogramas();
}
