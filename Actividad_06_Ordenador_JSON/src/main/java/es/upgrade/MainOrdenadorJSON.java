package es.upgrade;

import java.awt.event.PaintEvent;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.google.gson.Gson;

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
		
		ArrayList<Ram> rams = context.getBean("ramList",ArrayList.class);
		
		ArrayList<Periferico> perifericos = context.getBean("perifericosList",ArrayList.class);
		
		Ordenador o = context.getBean("ordenador",Ordenador.class);
		o.setNombre("Flameador 2024");
		o.setPrecio(1900);
		o.setProcesador(procesador);
		o.setPlacs_base(placaBase);
		o.setLista_rams(rams);
		o.setDisco_duro(discoDuro);
		o.setFuente_alimentacion(fuenteAlimentacion);
		o.setTarjeta_grafica(tarjetaGrafica);
		o.setLista_perifericos(perifericos);
		
		Gson gson = new Gson();
		String json = gson.toJson(o);
		System.out.println(json);
		
		String ordenadorJson = "{\"Ordenador\":{\"nombre\":\"Flameador 2024\",\"precio\":1900,\"procesador\":{\"marca\":\"Manker\",\"modelo\":\"9700X\",\"hz\":5000},\"placa_base\":{\"modelo\":\"B470\",\"marca\":\"iAmanoob\",\"slots_ram\":4},\"rams\":[{\"ram1\":{\"marca\":\"Flaming\",\"tipo\":\"DDR4\",\"capacidad\":\"8GB\",\"hz\":6000,\"cl\":30}},{\"ram2\":{\"marca\":\"Flaming\",\"tipo\":\"DDR4\",\"capacidad\":\"8GB\",\"hz\":6000,\"cl\":30}}],\"disco_duro\":{\"marca\":\"Manker\",\"tipo\":\"HDD\",\"capacidad\":\"2TB\"},\"fuente_alimentacion\":{\"marca\":\"Manker\",\"modelo\":\"ATX\",\"potencia\":750},\"tarjeta_grafica\":{\"marca\":\"iAmanoob\",\"modelo\":\"4080\",\"cudas\":9830},\"perifericos\":[{\"periferico\":{\"tipo\":\"Teclado\",\"nombre\":\"Flaming pro eco 2\",\"marca\":\"Flamer Gaming SL\"}},{\"periferico\":{\"tipo\":\"Ratón\",\"nombre\":\"Insultating pro 1\",\"marca\":\"Flamer Gaming SL\"}},{\"periferico\":{\"tipo\":\"Monitor\",\"nombre\":\"4K full de chill\",\"marca\":\"Munion S.L.\"}}]}}";
		Ordenador ordenador = gson.fromJson(ordenadorJson, Ordenador.class);
		System.out.println(ordenador);
	}

	@Bean
	public ArrayList<Ram> ramList(){
		ArrayList<Ram> rams = new ArrayList<Ram>();
		
		Ram r1 = new Ram();
		r1.setMarca("Flaming");
		r1.setTipo("DDR4");
		r1.setCapacidad("8GB");
		r1.setHz(6000);
		r1.setCl(30);
		
		Ram r2 = new Ram();
		r2.setMarca("Flaming");
		r2.setTipo("DDR4");
		r2.setCapacidad("8GB");
		r2.setHz(6000);
		r2.setCl(30);
				
		rams.add(r1);
		rams.add(r2);
		
		return rams;
	}
	
	@Bean
	public ArrayList<Periferico> perifericosList(){
		ArrayList<Periferico> perifericosList = new ArrayList<Periferico>();
		
		Periferico teclado = new Periferico();
		teclado.setTipo("Teclado");
		teclado.setNombre("Flaming pro eco 2");
		teclado.setMarca("Flamer Gaming SL");
		
		Periferico Raton = new Periferico();
		Raton.setTipo("Raton");
		Raton.setNombre("Insultating pro 1");
		Raton.setMarca("Flamer Gaming SL");
		
		Periferico Monitor = new Periferico();
		Monitor.setTipo("Monitor");
		Monitor.setNombre("4K full de chill");
		Monitor.setMarca("Munion S.L.");
		
		perifericosList.add(Raton);
		perifericosList.add(teclado);
		perifericosList.add(Monitor);
		
		return perifericosList;
	}

}
