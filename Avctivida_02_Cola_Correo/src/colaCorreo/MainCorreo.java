package colaCorreo;

public class MainCorreo {

	public static void main(String[] args) {
		Buffer buffer = new Buffer(5);
		
		ProducirCorreo p1 = new ProducirCorreo("Productor 1",buffer,"destinatario1@gmail.com", "remitente1@empresa.com", "asunto1", "Cuerpo1");
		ProducirCorreo p2 = new ProducirCorreo("Productor 2",buffer,"destinatario2@gmail.com", "remitente2@empresa.com", "asunto2", "Cuerpo2");
		ProducirCorreo p3 = new ProducirCorreo("Productor 3",buffer,"destinatario3@gmail.com", "remitente3@empresa.com", "asunto3", "Cuerpo3");
		
		ConsumirCorreo c1 = new ConsumirCorreo("Consumidor 1",buffer);
		ConsumirCorreo c2 = new ConsumirCorreo("Consumidor 2",buffer);
		

		p1.start();
		p2.start();
		p3.start();
		
		c1.start();
		c2.start();
	}

}
