package manejoHilos;

public class Hilo_02_02_Runnable implements Runnable{

	private String texto;
    private long n1;
    private long n2;
    
    public Hilo_02_02_Runnable(String texto, long n1, long n2) {
		super();
		this.texto = texto;
		this.n1 = n1;
		this.n2 = n2;
	}

	@Override
    public void run() {
        // Calcular la resta entre los números
        long repeticiones = n1 - n2;

        // Verificar que la resta no sea negativa
        if (repeticiones <= 0) {
            System.out.println("El resultado de la resta debe ser positivo para imprimir el texto.");
        }

        // Comenzar a medir el tiempo
        long tiempoInicio = System.currentTimeMillis();

        // Mostrar el String la cantidad de veces calculada
        for (int i = 0; i < repeticiones; i++) {
            System.out.println(texto);
        }

        // Calcular el tiempo final
        long tiempoFin = System.currentTimeMillis();

        // Mostrar el tiempo transcurrido
        System.out.println("Tiempo de ejecución: " + (tiempoFin - tiempoInicio) + " milisegundos");
    }
}