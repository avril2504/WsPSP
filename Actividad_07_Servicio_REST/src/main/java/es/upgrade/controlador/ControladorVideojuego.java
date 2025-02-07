
package es.upgrade.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.upgrade.modelo.entidad.Videojuego;
import es.upgrade.modelo.negocio.GestorVideojuego;
import es.upgrade.modelo.persistencia.DaoVideojuegoJPA;

@RestController
public class ControladorVideojuego {
	
	@Autowired
	private DaoVideojuegoJPA daoVideojuegoJPA;
	@Autowired
	private GestorVideojuego gestorVideojuego;

	@GetMapping(path= "videojuegos/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> getVideojuego(@PathVariable("id") int id){
		Videojuego v = daoVideojuegoJPA.buscar(id);
		if(v != null) {
			return new ResponseEntity<Videojuego>(v,HttpStatus.OK);
		}else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping(path= "videojuegos",consumes = MediaType.APPLICATION_JSON_VALUE,
			produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> altaVideojuego(@RequestBody Videojuego v){
		if(gestorVideojuego.existePorNombre(v.getNombre())) {
			return new ResponseEntity<Videojuego>(HttpStatus.BAD_REQUEST);
		}else {
			daoVideojuegoJPA.insertar(v);
		}
		
		return new ResponseEntity<Videojuego>(v,HttpStatus.CREATED);
	}
	
	@GetMapping(path="videojuegos",produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Videojuego>> listarVideojuegos(
			@RequestParam(name = "nombre",required = false) String nombre){
		List<Videojuego>listaVideojuegos = null;
		if(nombre == null) {
			listaVideojuegos = daoVideojuegoJPA.listar();
		}else {
			listaVideojuegos = daoVideojuegoJPA.listarPorNombre(nombre);
		}
		return new ResponseEntity<List<Videojuego>>(listaVideojuegos,HttpStatus.OK);
	}
	
	@PutMapping(path = "videojuegos/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> modificarVideojuego(@PathVariable("id") int id,
			@RequestBody Videojuego v){
		v.setId(id);
		Videojuego vUpdate = daoVideojuegoJPA.modificar(v);
		if (vUpdate != null) {
			return new ResponseEntity<Videojuego>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="videojuegos/{id}")
	public ResponseEntity<Videojuego> borrarVideojuego(@PathVariable("id") int id) {
		int v = daoVideojuegoJPA.borrar(id);
		if(v > 0) {
			return new ResponseEntity<Videojuego>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);
		}
	}
}
