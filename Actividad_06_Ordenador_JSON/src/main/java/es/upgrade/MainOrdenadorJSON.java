package es.upgrade;

import java.awt.event.PaintEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import es.upgrade.modelo.entidad.Disco_duro;
import es.upgrade.modelo.entidad.Fuente_alimentacion;
import es.upgrade.modelo.entidad.Ordenador;
import es.upgrade.modelo.entidad.Periferico;
import es.upgrade.modelo.entidad.Placa_base;
import es.upgrade.modelo.entidad.Procesador;
import es.upgrade.modelo.entidad.Ram;
import es.upgrade.modelo.entidad.Tarjeta_grafica;

@SpringBootApplication
public class MainOrdenadorJSON implements CommandLineRunner{

	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(MainOrdenadorJSON.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Disco_duro discoDuro = context.getBean("disco_duro",Disco_duro.class);
		discoDuro.setMarca("Manker");
		discoDuro.setTipo("HDD");
		discoDuro.setCapacidad("2TB");
		
		Fuente_alimentacion fuenteAlimentacion = context.getBean("fuente_alimentacion",Fuente_alimentacion.class);
		fuenteAlimentacion.setMarca("Manker");
		fuenteAlimentacion.setModelo("ATX");
		fuenteAlimentacion.setPotencia(750);
		
		Placa_base placaBase = context.getBean("placa_base",Placa_base.class);
		placaBase.setModelo("B470");
		placaBase.setMarca("iAmanoob");
		placaBase.setSlots_ram(4);
		
		Procesador procesador = context.getBean("procesador",Procesador.class);
		procesador.setMarca("Manker");
		procesador.setModelo("9700X");
		procesador.setHz(5000);
		
		Tarjeta_grafica tarjetaGrafica = context.getBean("tarjeta_grafica",Tarjeta_grafica.class);
		tarjetaGrafica.setMarca("iAmanoob");
		tarjetaGrafica.setModelo("4080");
		tarjetaGrafica.setCudas(750);
		
		Ram ram = context.getBean("ram",Ram.class);
		ram.setMarca("Flaming");
		ram.setTipo("DDR4");
		ram.setCapacidad("8GB");
		ram.setHz(6000);
		ram.setCl(30);
		
		Ram ram2 = context.getBean("ram2",Ram.class);
		
		Periferico periferico = context.getBean("periferico",Periferico.class);
		periferico.setTipo("Teclado");
		periferico.setNombre("Flaming pro eco 2");
		periferico.setMarca("Flamer Gaming SL");
		
		Periferico periferico2 = context.getBean("periferico2",Periferico.class);
		Periferico periferico3 = context.getBean("periferico3",Periferico.class);
		
		Ordenador o = context.getBean("ordenador",Ordenador.class);
		
		
	}

	@Bean
	public Ram ram2() {
		Ram ram = new Ram();
		ram.setMarca("Flaming");
		ram.setTipo("DDR4");
		ram.setCapacidad("8GB");
		ram.setHz(6000);
		ram.setCl(30);
		return ram;
		
	}
	
	@Bean
	public Periferico periferico2() {
		Periferico periferico = new Periferico();
		periferico.setTipo("Ratón");
		periferico.setNombre("Insultating pro 1");
		periferico.setMarca("Flamer Gaming SL");
		return periferico;
		
	}
	
	@Bean
	public Periferico periferico3() {
		Periferico periferico = new Periferico();
		periferico.setTipo("Monitor");
		periferico.setNombre("4K full de chill");
		periferico.setMarca("Munion S.L.");
		return periferico;
		
	}

}
