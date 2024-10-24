package manejoHilos;

public class Hilo_02_Thread extends Thread{
	
	 private long inicio;
	 

	
	public Hilo_02_Thread(long inicio) {
		super();
		this.inicio = inicio;
	}

	public static void mostrarNumerosDesde(long inicio) {
        // Mostrar números desde el inicio hasta 1.000.000.000
        for (long i = inicio; i <= 1_000_000_000; i++) {
            System.out.println(i);

            // Para evitar una salida masiva, puedes comentar esta línea
            // si deseas imprimir todos los números hasta 1.000.000.000
            if (i % 1_000_000 == 0) { // Mostrar cada millón
                System.out.println("Mostrando hasta: " + i);
            }
        }
    }
	
	public void run() {
		
		long tiempoInicio = System.nanoTime();
        mostrarNumerosDesde(inicio);
        long tiempoFin = System.nanoTime();
        
        long tiempoEjecucion = tiempoFin - tiempoInicio;
        System.out.printf("Tiempo de ejecución desde %d: %d nanosegundos%n", inicio, tiempoEjecucion);
    
		
	}

}
