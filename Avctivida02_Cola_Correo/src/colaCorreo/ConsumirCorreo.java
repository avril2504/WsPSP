package colaCorreo;

class ConsumirCorreo extends Thread{
	private Buffer buffer;

	public ConsumirCorreo(Buffer buffer) {
		super();
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				buffer.quitarCorreo();
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
