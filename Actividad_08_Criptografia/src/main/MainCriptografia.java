package main;

import java.util.Scanner;

import gestor.GestorCriptografia;

public class MainCriptografia {

	public static void main(String[] args) {
		 try {
	            Scanner scanner = new Scanner(System.in);
	            GestorCriptografia gestorCriptografia = new GestorCriptografia();

	            while (true) {
	                mostrarMenu();
	                System.out.print("Seleccione una opción: ");
	                int opcion = scanner.nextInt();
	                scanner.nextLine(); // Consumir el salto de línea

	                switch (opcion) {
	                    case 1:
	                        System.out.print("Ingrese la frase a encriptar (AES): ");
	                        String fraseAES = scanner.nextLine();
	                        gestorCriptografia.encriptarAES(fraseAES);
	                        System.out.println("Frase encriptada correctamente.");
	                        break;
	                    case 2:
	                        System.out.println("Frase encriptada (AES): " + gestorCriptografia.obtenerFraseEncriptadaAES());
	                        break;
	                    case 3:
	                        System.out.println("Frase desencriptada (AES): " + gestorCriptografia.desencriptarAES());
	                        break;
	                    case 4:
	                        System.out.print("Ingrese la frase a encriptar para confidencialidad (RSA): ");
	                        String fraseConfidencial = scanner.nextLine();
	                        gestorCriptografia.encriptarConfidencialidad(fraseConfidencial);
	                        System.out.println("Frase encriptada con confidencialidad.");
	                        break;
	                    case 5:
	                        System.out.print("Ingrese la frase a encriptar para autenticidad (RSA): ");
	                        String fraseAutenticidad = scanner.nextLine();
	                        gestorCriptografia.encriptarAutenticidad(fraseAutenticidad);
	                        System.out.println("Frase encriptada con autenticidad.");
	                        break;
	                    case 6:
	                        System.out.println("Frase desencriptada confidencialmente: " + gestorCriptografia.desencriptarConfidencialidad());
	                        break;
	                    case 7:
	                        System.out.println("Frase autenticada correctamente: " + gestorCriptografia.desencriptarAutenticidad());
	                        break;
	                    case 8:
	                        System.out.println("Saliendo del programa...");
	                        scanner.close();
	                        return;
	                    default:
	                        System.out.println("Opción inválida. Intente nuevamente.");
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    // Método para mostrar el menú
	    private static void mostrarMenu() {
	        System.out.println("\nMenú:");
	        System.out.println("1. Encriptar frase (AES)");
	        System.out.println("2. Mostrar frase encriptada (AES)");
	        System.out.println("3. Desencriptar frase (AES)");
	        System.out.println("4. Encriptar frase confidencial (RSA - Clave Pública)");
	        System.out.println("5. Encriptar frase para autenticidad (RSA - Clave Privada)");
	        System.out.println("6. Desencriptar frase confidencial (RSA - Clave Privada)");
	        System.out.println("7. Desencriptar frase autenticada (RSA - Clave Pública)");
	        System.out.println("8. Salir");
	    }
	}
