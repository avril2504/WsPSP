package es.upgrade.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.upgrade.modelo.entidad.Videojuego;
import es.upgrade.modelo.persistencia.DaoVideojuegoJPA;

@Component
public class GestorVideojuego {
	@Autowired
	private DaoVideojuegoJPA daoVideojuegoJPA;
	
	public boolean existePorNombre(String nombre) {
		Videojuego VideojuegoPorNombre = daoVideojuegoJPA.buscarPorNombre(nombre);
		if(VideojuegoPorNombre == null || VideojuegoPorNombre.getNombre().isBlank()) {
			return false;
		}
		return true;
	}

}
