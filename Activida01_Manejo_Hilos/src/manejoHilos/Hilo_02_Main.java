package manejoHilos;

import java.util.Scanner;

public class Hilo_02_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner scString = new Scanner(System.in);

		
		System.out.println("Introduzca el primer numero");
		long n1 = sc.nextLong();
		
		System.out.println("Introduzca el segundo numero");
		long n2 = sc.nextLong();
		
		System.out.println("Introduzca una frase");

		String frase = scString.nextLine();
		
		Hilo_02_Runnable hilo = new Hilo_02_Runnable(n1);
		Thread hilo1 = new Thread(hilo);
		
		Hilo_02_Thread hilo2 = new Hilo_02_Thread(n2);
		hilo2.setName("hilo2");
		
		Hilo_02_02_Runnable hilo02 = new Hilo_02_02_Runnable(frase, n1, n2);
		Thread hilo3 = new Thread(hilo02);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();

	}

}
