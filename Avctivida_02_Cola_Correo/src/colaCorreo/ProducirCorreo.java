package colaCorreo;

public class ProducirCorreo extends Thread{
	
	private Buffer buffer;
	private String pDestinatario;
	private String pRemitente;
	private String pAsunto;
	private String pCuerpoMensaje;


	public ProducirCorreo(String name,Buffer buffer, String pDestinatario, String pRemitente, String pAsunto,
			String pCuerpoMensaje) {
		super(name);
		this.buffer = buffer;
		this.pDestinatario = pDestinatario;
		this.pRemitente = pRemitente;
		this.pAsunto = pAsunto;
		this.pCuerpoMensaje = pCuerpoMensaje;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			Correo correo = new Correo(pDestinatario, pRemitente, pAsunto + "" + i, pCuerpoMensaje + "" + i);
			try {
				buffer.addCorreo(correo);
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
			
	}
	

}
