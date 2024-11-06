package colaCorreo;

class ConsumirCorreo extends Thread{
	private Buffer buffer;

	public ConsumirCorreo(String name,Buffer buffer) {
		super(name);
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Correo correo = buffer.quitarCorreo();
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
