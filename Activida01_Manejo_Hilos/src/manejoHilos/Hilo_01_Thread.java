package manejoHilos;

public class Hilo_01_Thread extends Thread{
	
	private long numero;
	
	public Hilo_01_Thread(long numero) {
		super();
		this.numero = numero;
		
	}
		
		public boolean esPrimo(long numero) {
	        // Los números menores o iguales a 1 no son primos.
	        if (numero <= 1) {
	            return false;
	        }
	        // Verificamos si numero tiene divisores
	        for (int i = 2; i <= Math.sqrt(numero); i++) {
	            if (numero % i == 0) {
	                return false; // numero es divisible, no es primo
	            }
	        }
	        return true; // n no tiene divisores, es primo
	    
	}

	public void run() {
		
		 long inicio = System.nanoTime();
	        boolean esPrimo = esPrimo(numero);
	        long fin = System.nanoTime();
	        long tiempoEjecucion = fin - inicio;

	        System.out.printf("Número: %d, Hilo: %s, Tiempo: %d nanosegundos, Primo: %s%n",
	                          numero, Thread.currentThread().getName(), tiempoEjecucion, esPrimo ? "Sí" : "No");

		
		
	}

}
