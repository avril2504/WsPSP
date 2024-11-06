package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidor {
	
	public static final int PUERTO = 2024;
	
	public static void main(String[] args) {
		System.out.println("     SERVIDOR     ");
		
		InputStreamReader entrada = null;
		PrintStream salida = null;
		Socket socketAlCliente = null;
		InetSocketAddress direccion = new InetSocketAddress(PUERTO);
		
		try (ServerSocket serverSocket = new ServerSocket()){			

			serverSocket.bind(direccion);
			
			int peticion = 0;
			while(true){		
				
				System.out.println("SERVIDOR: Esperando peticion por el puerto " + PUERTO);

				socketAlCliente = serverSocket.accept();
				System.out.println("SERVIDOR: peticion numero " + ++peticion + " recibida");
				
				entrada = new InputStreamReader(socketAlCliente.getInputStream());
				BufferedReader bf = new BufferedReader(entrada);
				
				String stringRecibido = bf.readLine();//3-4
				
				System.out.println("SERVIDOR: Me ha llegado del cliente: " + stringRecibido);

				String[] operadores = stringRecibido.split("_");
				int n1 = Integer.parseInt(operadores[0]);//3
				int n2 = Integer.parseInt(operadores[1]);//4
				String opcion = operadores[2];
				
				String resultado = null;
				if (opcion.equals("a")) {
					resultado = String.valueOf(n1 + n2);
				} else if (opcion.equals("b")) {
					resultado = String.valueOf(n1 - n2);
				} else if (opcion.equals("c")) {
					resultado = String.valueOf(n1 * n2);
				} else if (opcion.equals("d")) {
					resultado = String.valueOf(n1 / n2);
				} else if (opcion.equals("e")) {
					System.out.println("Saliste del programa");
				}
				
					
				System.out.println("SERVIDOR: El calculo de los numeros es: " + resultado);
								

				salida = new PrintStream(socketAlCliente.getOutputStream());
				salida.println(resultado);	

				socketAlCliente.close();
			}
		} catch (IOException e) {
			System.err.println("SERVIDOR: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("SERVIDOR: Error -> " + e);
			e.printStackTrace();
		}
	}//FIN DEL PROGRAMA
}
