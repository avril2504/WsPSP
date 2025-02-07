package es.upgrade.modelo.persistencia;

import java.util.List;

import org.springframework.stereotype.Component;

import es.upgrade.modelo.entidad.Videojuego;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Component
public class DaoVideojuegoJPA {

	private EntityManager em;
	
	private boolean abrirConexion(){
		try {
			EntityManagerFactory factoria = Persistence.createEntityManagerFactory("PruebaJPA");
			em = factoria.createEntityManager();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean cerrarConexion() {
		try {
			em.close();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int insertar(Videojuego v) {
		if(!abrirConexion()) {
			return 0;
		}
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(v);
		et.commit();
		cerrarConexion();
		return v.getId();
	}


	public int borrar(int id) {
		if(!abrirConexion()) {
			return 0;
		}
		Videojuego vAux = buscar(id);
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(vAux);
		et.commit();
		cerrarConexion();
		return vAux.getId();
	}


	public Videojuego modificar(Videojuego v) {
		if(!abrirConexion()) {
			return null;
		}
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		v = em.merge(v);
		et.commit();
		cerrarConexion();
		return v;
	}


	public Videojuego buscar(int id) {
		if(!abrirConexion()) {
			return null;
		}
		return em.find(Videojuego.class, id);
	}
	
	public Videojuego buscarPorNombre(String nombre) {
		 if (!abrirConexion()) {
		        return null;
		    }

		    // Crear una consulta JPQL para buscar por nombre
		    String jpql = "SELECT v FROM Videojuego v WHERE v.nombre = :nombre";
		    TypedQuery<Videojuego> query = em.createQuery(jpql, Videojuego.class);
		    query.setParameter("nombre", nombre);

		    // Ejecutar la consulta y devolver el primer resultado
		    try {
		        return query.getSingleResult(); // Devuelve el videojuego si lo encuentra
		    } catch (NoResultException e) {
		        return null; // No encontró el videojuego con ese nombre
		    }
	}

	@SuppressWarnings("unchecked")
	public List<Videojuego> listar() {
	    if (!abrirConexion()) {
	        return null;
	    }

	    try {
	        Query query = em.createQuery("SELECT v FROM Videojuego v");
	        List<Videojuego> listaVideojuego = query.getResultList();
	        return listaVideojuego;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        cerrarConexion();
	    }
	}

	
	@SuppressWarnings("unchecked")
	public List<Videojuego> listarPorNombre(String nombre) {
	    if (!abrirConexion()) {
	        return null;
	    }
	    
	    try {
	        Query query = em.createQuery("SELECT v FROM Videojuego v WHERE v.nombre LIKE :nombre");
	        query.setParameter("nombre", "%" + nombre + "%");
	        
	        List<Videojuego> listaVideojuego = query.getResultList();
	        return listaVideojuego;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        cerrarConexion();
	    }
	}


}
