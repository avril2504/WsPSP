package es.upgrade.modelo.entidad;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope("prototype")
public class Fuente_alimentacion {
	private String marca;
	private String modelo;
	private int potencia;
}
