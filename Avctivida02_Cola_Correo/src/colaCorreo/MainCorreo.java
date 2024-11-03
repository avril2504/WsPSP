package colaCorreo;

public class MainCorreo {

	public static void main(String[] args) {
		Buffer buffer = new Buffer(5);
		
		ProducirCorreo p1 = new ProducirCorreo(buffer,"destinatario1@gmail.com", "remitente1@empresa.com", "asunto1", "Cuerpo1");
		ProducirCorreo p2 = new ProducirCorreo(buffer,"destinatario2@gmail.com", "remitente2@empresa.com", "asunto2", "Cuerpo2");
		ProducirCorreo p3 = new ProducirCorreo(buffer,"destinatario3@gmail.com", "remitente3@empresa.com", "asunto3", "Cuerpo3");
		
		ConsumirCorreo c1 = new ConsumirCorreo(buffer);
		ConsumirCorreo c2 = new ConsumirCorreo(buffer);
		
		p1.setName("Productor 1");
		p1.start();
		
		p2.setName("Productor 2");
		p2.start();
		
		p3.setName("Productor 3");
		p3.start();
		
		c1.setName("Consumidor 1");
		c1.start();
		
		c2.setName("Consumidor 2");
		c2.start();
	}

}
