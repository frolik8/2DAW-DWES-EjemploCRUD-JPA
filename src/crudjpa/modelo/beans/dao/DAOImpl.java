package crudjpa.modelo.beans.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TransactionRequiredException;

public class DAOImpl implements DAO {

	private String unidadPersistencia;
	
	public DAOImpl(String unidadPersistencia) {
		this.unidadPersistencia = unidadPersistencia;
	}
	@Override
	/**
	 * Persistencia de una entidad
	 */
	public boolean insert(Object entidad) {
		
		boolean ok = false;
		
		// Inicialización de objetos relacionados con JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(unidadPersistencia);
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		
		try {
			tx.begin();
			
			// Se comprueba si la transacción está activa. Debe estarlo.
			if (tx.isActive())
				System.out.println("Transacción activa.<br>");
			else
				System.out.println("Cuidado: Transacción no activa.<br>");
			
			// Se procede a efectuar la persistencia (inserción)
			em.persist(entidad);
			
			// Se completa la transacción
			tx.commit();
			
			// Todo correcto
			ok = true;
		} catch (EntityExistsException e) {
			System.out.println("Excepción de existencia previa de la entidad.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (IllegalArgumentException e) {
			System.out.println("Excepción de instancia no es tipo entidad.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (TransactionRequiredException e) {
			System.out.println("Problema con configuración de transacción.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (RollbackException e) {
			System.out.println("El commit ha fallado.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (Exception e) {
			Genero genero = (Genero) entidad;
			System.out.println("Error desconocido en transacción con objeto Genero: "+ genero.getGenero()+"<br>");
			e.printStackTrace();
			if (tx.isActive())
				tx.rollback();
		}
		finally {
			em.close();
			emf.close();
		}

		return ok;
	}

	@Override
	public Genero getGenero(String id) {
		
		Genero genero = null;
		
		// Inicialización de objetos relacionados con JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(unidadPersistencia);
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			// Se comprueba si la transacción está activa. Debe estarlo.
			if (tx.isActive())
				System.out.println("Transacción activa.<br>");
			else
				System.out.println("Cuidado: Transacción no activa.<br>");
			
			// Se hace una búsqueda
			genero = em.find(Genero.class, id);
			if (genero != null)
				System.out.println("Género encontrado: "+genero.getGenero()+"<br>");
			else
				System.out.println("No se ha encontrado <br>");
			
			// Se completa la transacción
			tx.commit();
			
			// Desvinculamos de la persistencia
			em.detach(genero);
			
		} catch (EntityExistsException e) {
			System.out.println("Excepción de existencia previa de la entidad.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (IllegalArgumentException e) {
			System.out.println("Excepción de instancia no es tipo entidad.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (TransactionRequiredException e) {
			System.out.println("Problema con configuración de transacción.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (RollbackException e) {
			System.out.println("El commit ha fallado.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (Exception e) {
			System.out.println("Error desconocido en transacción con objeto Genero: "+ genero.getGenero()+"<br>");
			e.printStackTrace();
			if (tx.isActive())
				tx.rollback();
		}
		finally {
			em.close();
			emf.close();
		}
		return genero;
	}
	@Override
	public boolean updateUsuario(Usuario usuario) {
		boolean ok = false;
		
		Usuario usuarioAct = null;
		
		// Inicialización de objetos relacionados con JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(unidadPersistencia);
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			// Se comprueba si la transacción está activa. Debe estarlo.
			if (tx.isActive())
				System.out.println("Transacción activa.<br>");
			else
				System.out.println("Cuidado: Transacción no activa.<br>");
			
			// Se hace una búsqueda
			usuarioAct = em.find(Usuario.class, usuario.getLogin());
			if (usuarioAct != null) {
				System.out.println("Usuario encontrado: "+usuarioAct.getLogin()+"<br>");
				System.out.println("Se actualizan los datos del usuario por: "+usuario.getClave()+"-"+usuario.getNombre()+"-"+usuario.getEmail());
				em.detach(usuarioAct);
				usuarioAct.setClave(usuario.getClave());
				usuarioAct.setNombre(usuario.getNombre());
				usuarioAct.setEmail(usuario.getEmail());
				em.merge(usuarioAct);

				// Todo correcto
				ok = true;
			}
			else
				System.out.println("No se ha encontrado <br>");
			
			// Se completa la transacción
			tx.commit();
			
		} catch (EntityExistsException e) {
			System.out.println("Excepción de existencia previa de la entidad.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (IllegalArgumentException e) {
			System.out.println("Excepción de instancia no es tipo entidad.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (TransactionRequiredException e) {
			System.out.println("Problema con configuración de transacción.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (RollbackException e) {
			System.out.println("El commit ha fallado.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (Exception e) {
			System.out.println("Error desconocido en transacción con objeto Usuario:<br>");
			e.printStackTrace();
			if (tx.isActive())
				tx.rollback();
		}
		finally {
			em.close();
			emf.close();
		}
		
		return ok;
	}
	@Override
	public boolean removeUsuario(String login) {
		boolean ok = false;
		
		Usuario usuario = null;
		
		// Inicialización de objetos relacionados con JPA
				EntityManagerFactory emf = Persistence.createEntityManagerFactory(unidadPersistencia);
				EntityManager em = emf.createEntityManager();
				EntityTransaction tx = em.getTransaction();
				
				try {
					tx.begin();
					
					// Se comprueba si la transacción está activa. Debe estarlo.
					if (tx.isActive())
						System.out.println("Transacción activa.<br>");
					else
						System.out.println("Cuidado: Transacción no activa.<br>");
					
					// Busco una entidad con ese login, si la encuentra, me traigo el id, que es el login.
					usuario = em.getReference(Usuario.class, login);
					usuario.getLogin();
					
					// Se elimina de la base de datos al usuario
					em.remove(usuario);
					
					// Se completa la transacción
					tx.commit();
					
					// Todo correcto
					ok = true;
					
				} catch (EntityExistsException e) {
					System.out.println("Excepción de existencia previa de la entidad.<br>");
					if (tx.isActive())
						tx.rollback();
				} catch (IllegalArgumentException e) {
					System.out.println("Excepción de instancia no es tipo entidad.<br>");
					if (tx.isActive())
						tx.rollback();
				} catch (TransactionRequiredException e) {
					System.out.println("Problema con configuración de transacción.<br>");
					if (tx.isActive())
						tx.rollback();
				} catch (RollbackException e) {
					System.out.println("El commit ha fallado.<br>");
					if (tx.isActive())
						tx.rollback();
				} catch (EntityNotFoundException e) {
					System.out.println("No se ha encontrado la entidad buscada.<br>");
					if (tx.isActive())
						tx.rollback();
				} catch (Exception e) {
					System.out.println("Error desconocido en transacción con objeto Usuario: "+ usuario.getLogin()+"<br>");
					e.printStackTrace();
					if (tx.isActive())
						tx.rollback();
				}
				finally {
					em.close();
					emf.close();
				}
				
		return ok;
	}
	@Override
	public List<Fotograma> getFotogramas() {
		List<Fotograma> listaFotogramas = null;
		
		// Inicialización de objetos relacionados con JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(unidadPersistencia);
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Query query = null;
		
		
		try {
			tx.begin();
			
			// Se comprueba si la transacción está activa. Debe estarlo.
			if (tx.isActive())
				System.out.println("Transacción activa.<br>");
			else
				System.out.println("Cuidado: Transacción no activa.<br>");
			
			query = em.createNamedQuery("Fotograma.findAll");
			
			listaFotogramas = query.getResultList();
			
			// Se completa la transacción
			tx.commit();
			
			
		} catch (EntityExistsException e) {
			System.out.println("Excepción de existencia previa de la entidad.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (IllegalArgumentException e) {
			System.out.println("Excepción de instancia no es tipo entidad.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (TransactionRequiredException e) {
			System.out.println("Problema con configuración de transacción.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (RollbackException e) {
			System.out.println("El commit ha fallado.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (Exception e) {
			System.out.println("Error desconocido en transacción con lista de objetos fotograma.<br>");
			e.printStackTrace();
			if (tx.isActive())
				tx.rollback();
		}
		finally {
			em.close();
			emf.close();
		}
		
		return listaFotogramas;
	}
	@Override
	public List<Usuario> getUsuarios() {
		List<Usuario> listaUsuarios = null;
		
		// Inicialización de objetos relacionados con JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(unidadPersistencia);
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Query query = null;
		
		
		try {
			tx.begin();
			
			// Se comprueba si la transacción está activa. Debe estarlo.
			if (tx.isActive())
				System.out.println("Transacción activa.<br>");
			else
				System.out.println("Cuidado: Transacción no activa.<br>");
			
			query = em.createNamedQuery("Usuario.findAll");
			
			listaUsuarios = (List<Usuario>) query.getResultList();
			
			// Se completa la transacción
			tx.commit();
			
			
		} catch (EntityExistsException e) {
			System.out.println("Excepción de existencia previa de la entidad.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (IllegalArgumentException e) {
			System.out.println("Excepción de instancia no es tipo entidad.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (TransactionRequiredException e) {
			System.out.println("Problema con configuración de transacción.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (RollbackException e) {
			System.out.println("El commit ha fallado.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (Exception e) {
			System.out.println("Error desconocido en transacción con lista de objetos usuario.<br>");
			e.printStackTrace();
			if (tx.isActive())
				tx.rollback();
		}
		finally {
			em.close();
			emf.close();
		}
		
		return listaUsuarios;
	}
	@Override
	public List<Directores> getDirectores() {
		List<Directores> listaDirectores = null;
		
		// Inicialización de objetos relacionados con JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(unidadPersistencia);
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Query query = null;
		
		
		try {
			tx.begin();
			
			// Se comprueba si la transacción está activa. Debe estarlo.
			if (tx.isActive())
				System.out.println("Transacción activa.<br>");
			else
				System.out.println("Cuidado: Transacción no activa.<br>");
			
			query = em.createNamedQuery("Directores.findAll");
			
			listaDirectores = (List<Directores>) query.getResultList();
			
			// Se completa la transacción
			tx.commit();
			
			
		} catch (EntityExistsException e) {
			System.out.println("Excepción de existencia previa de la entidad.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (IllegalArgumentException e) {
			System.out.println("Excepción de instancia no es tipo entidad.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (TransactionRequiredException e) {
			System.out.println("Problema con configuración de transacción.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (RollbackException e) {
			System.out.println("El commit ha fallado.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (Exception e) {
			System.out.println("Error desconocido en transacción con lista de objetos usuario.<br>");
			e.printStackTrace();
			if (tx.isActive())
				tx.rollback();
		}
		finally {
			em.close();
			emf.close();
		}
		
		return listaDirectores;
	}
	@Override
	public List<Administrador> getAdministradores() {
		List<Administrador> listaAdministradores = null;
		
		// Inicialización de objetos relacionados con JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(unidadPersistencia);
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Query query = null;
		
		
		try {
			tx.begin();
			
			// Se comprueba si la transacción está activa. Debe estarlo.
			if (tx.isActive())
				System.out.println("Transacción activa.<br>");
			else
				System.out.println("Cuidado: Transacción no activa.<br>");
			
			query = em.createNamedQuery("Administrador.findAll");
			
			listaAdministradores = (List<Administrador>) query.getResultList();
			System.out.println("Numero administradores: "+listaAdministradores.size());
			// Se completa la transacción
			tx.commit();
			
			
		} catch (EntityExistsException e) {
			System.out.println("Excepción de existencia previa de la entidad.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (IllegalArgumentException e) {
			System.out.println("Excepción de instancia no es tipo entidad.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (TransactionRequiredException e) {
			System.out.println("Problema con configuración de transacción.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (RollbackException e) {
			System.out.println("El commit ha fallado.<br>");
			if (tx.isActive())
				tx.rollback();
		} catch (Exception e) {
			System.out.println("Error desconocido en transacción con lista de objetos usuario.<br>");
			e.printStackTrace();
			if (tx.isActive())
				tx.rollback();
		}
		finally {
			em.close();
			emf.close();
		}
		
		return listaAdministradores;
	}
}
