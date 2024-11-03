package colaCorreo;

public class Correo {
	private static int idcontador = 1;
	private int id;
	private String destinatario;
	private String remitente;
	private String asunto;
	private String cuerpoMensaje;
	public int getId() {
		return id;
	}

	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getRemitente() {
		return remitente;
	}
	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getCuerpoMensaje() {
		return cuerpoMensaje;
	}
	public void setCuerpoMensaje(String cuerpoMensaje) {
		this.cuerpoMensaje = cuerpoMensaje;
	}
	public Correo(String destinatario, String remitente, String asunto, String cuerpoMensaje) {
		super();
		this.id = idcontador++;
		this.destinatario = destinatario;
		this.remitente = remitente;
		this.asunto = asunto;
		this.cuerpoMensaje = cuerpoMensaje;
	}
	

	@Override
	public String toString() {
		return "Correo [id=" + id + ", destinatario=" + destinatario + ", remitente=" + remitente + ", asunto=" + asunto
				+ ", cuerpoMensaje=" + cuerpoMensaje + "]";
	}
	
	

}
