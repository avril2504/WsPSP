package es.upgrade.modelo.entidad;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope("prototype")
public class Ram {
	private String marca;
	private String tipo;
	private String capacidad;
	private int hz;
	private int cl;
	
	@Override
    public String toString() {
        return "Ram{" +
                "marca='" + marca + '\'' +
                ", tipo='" + tipo + '\'' +
                ", capacidad='" + capacidad + '\'' +
                ", hz=" + hz +
                ", cl=" + cl +
                '}';
    }
}
