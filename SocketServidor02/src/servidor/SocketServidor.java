package servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidor {

	public static final int PUERTO = 2017;

	public static void main(String[] args) {

		System.out.println("     SERVIDOR     ");

		InetSocketAddress direccion = new InetSocketAddress(PUERTO);

		try (ServerSocket serverSocket = new ServerSocket()) {
			serverSocket.bind(direccion);

			int contadorJugador1 = 0;
			int contadorJugador2 = 0;
			boolean juegoTerminado = false;

			System.out.println("SERVIDOR: Esperando a los jugadores en el puerto " + PUERTO);

			Socket socketJugador1 = serverSocket.accept();
			Socket socketJugador2 = serverSocket.accept();
			BufferedReader entradaJugador1 = new BufferedReader(new InputStreamReader(socketJugador1.getInputStream()));
			PrintStream salidaJugador1 = new PrintStream(socketJugador1.getOutputStream());
			BufferedReader entradaJugador2 = new BufferedReader(new InputStreamReader(socketJugador2.getInputStream()));
			PrintStream salidaJugador2 = new PrintStream(socketJugador2.getOutputStream());

			System.out.println("SERVIDOR: Jugadores conectados");

			while (!juegoTerminado) {

				// Leer los movimientos de ambos jugadores
				String movimientoJugador1 = entradaJugador1.readLine();
				String movimientoJugador2 = entradaJugador2.readLine();
				System.out.println(movimientoJugador1);
				System.out.println(movimientoJugador2);

				// Determinar el ganador de la ronda
				String resultado = ganador(movimientoJugador1, movimientoJugador2);

				if (resultado.equals("jugador1 gana")) {
					contadorJugador1++;
				} else if (resultado.equals("jugador2 gana")) {
					contadorJugador2++;
				}

				// Enviar el marcador actualizado a ambos jugadores
				String marcador = "Marcador - Jugador 1: " + contadorJugador1 + " | Jugador 2: " + contadorJugador2;
				salidaJugador1.println(marcador);
				salidaJugador2.println(marcador);
				System.out.println(marcador);

				// Verificar si alguien ha ganado el juego
				if (contadorJugador1 == 3 || contadorJugador2 == 3) {
					String mensajeFinal = "Juego terminado: "
							+ (contadorJugador1 == 3 ? "Jugador 1 es el gran ganador" : "Jugador 2 es el gran ganador");
					salidaJugador1.println(mensajeFinal);
					salidaJugador2.println(mensajeFinal);
					System.out.println(mensajeFinal);
					juegoTerminado = true;
				}

			}

		} catch (Exception e) {
			System.out.println("Error en el servidor: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static String ganador(String jugador1, String jugador2) {
		if (jugador1.equals(jugador2)) {
			return "Empate";
		}

		switch (jugador1) {
		case "piedra":
			return jugador2.equals("tijera") ? "jugador1 gana" : "jugador2 gana";
		case "tijera":
			return jugador2.equals("papel") ? "jugador1 gana" : "jugador2 gana";
		case "papel":
			return jugador2.equals("piedra") ? "jugador1 gana" : "jugador2 gana";
		default:
			return "Entrada no válida";
		}
	}
}