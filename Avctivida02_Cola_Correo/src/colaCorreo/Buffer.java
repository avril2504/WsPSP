package colaCorreo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
	private int capacidad = 5;
	private Queue<Correo> listaCorreo = new LinkedList<Correo>();
	
	public Buffer(int capacidad) {
		super();
		this.capacidad = capacidad;
	}
	
	public synchronized void addCorreo(Correo correo) throws InterruptedException {
		if(correo.getDestinatario().equalsIgnoreCase("pikachu@gmail.com")) {
			System.out.println("Destinatario prohibido");
			return;
		}
		
		while (listaCorreo.size() == capacidad) {
			wait();
		}
		
		listaCorreo.add(correo);
		System.out.println("Se agrego el correo con id: " + correo.getId());
		notify();
	}
	
	public synchronized Correo quitarCorreo() throws InterruptedException{
		while (listaCorreo.isEmpty()) {
			wait();
		}
		
		Correo correo = listaCorreo.poll();
		System.out.println("Se envio el correo: " + correo);
		notify();
		return correo;
	}
}
