package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketCliente {
	public static final int PUERTO = 2024;
	public static final String IP_SERVER = "localhost";
	
	public static void main(String[] args) {
		System.out.println("     CALCULADORA     ");
		
		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);
		
		try (Scanner sc = new Scanner(System.in);
				Socket socketAlServidor = new Socket()){
			
			System.out.println("Introduzca un número");
			String numero1 = sc.nextLine();
			System.out.println("Introduzca otro número");
			String numero2 = sc.nextLine();
			
			System.out.println("--------------Menu---------------");
			System.out.println("a para sumar");
			System.out.println("b para restar");
			System.out.println("c para multiplicar");
			System.out.println("d para dividir");
			System.out.println("e para salir del programa");
			
			System.out.println("Introduzca la operación que desee");
			String opcion = sc.nextLine();
			
			String valores = numero1 + "_" + numero2 + "_" + opcion;
			
			System.out.println("CLIENTE: Esperando a que el servidor acepte la conexión");
			socketAlServidor.connect(direccionServidor);			
			System.out.println("CLIENTE: Conexion establecida... a " + IP_SERVER 
					+ " por el puerto " + PUERTO);	
			
			PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());
			
			salida.println(valores);
			
			InputStreamReader entrada = new InputStreamReader(socketAlServidor.getInputStream());

			BufferedReader bf = new BufferedReader(entrada);
			
			System.out.println("CLIENTE: Esperando al resultado del servidor...");

			String resultado = bf.readLine();
				
			System.out.println("CLIENTE: El resultado de la suma es: " + resultado);
			
		} catch (UnknownHostException e) {
			System.err.println("CLIENTE: No encuentro el servidor en la dirección" + IP_SERVER);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("CLIENTE: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("CLIENTE: Error -> " + e);
			e.printStackTrace();
		}
		
		System.out.println("CLIENTE: Fin del programa");
	}

}

