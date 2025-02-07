package es.upgrade.modelo.entidad;

import java.util.List;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope("prototype")
public class Ordenador {
	private String nombre;
	private  double precio;
	private Procesador procesador;
	private Placa_base placs_base;
	private List<Ram> lista_rams;
	private Disco_duro disco_duro;
	private Fuente_alimentacion fuente_alimentacion;
	private Tarjeta_grafica tarjeta_grafica;
	private List<Periferico> lista_perifericos;

}
