package manejoHilos;

import java.util.Scanner;

public class Hilo_01_Thread_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca el primer numero");
		long n1 = sc.nextLong();
		
		System.out.println("Introduzca el segundo numero");
		long n2 = sc.nextLong();
		
		System.out.println("Introduzca el tercer numero");
		long n3 = sc.nextLong();
		
		
		Hilo_01_Thread hilo1 = new Hilo_01_Thread(n1);
		hilo1.setName("hilo1");
		
		Hilo_01_Thread hilo2 = new Hilo_01_Thread(n2);
		hilo2.setName("hilo2");
		
		Hilo_01_Thread hilo3 = new Hilo_01_Thread(n3);
		hilo3.setName("hilo3");
		
		hilo1.start();
		hilo2.start();
		hilo3.start();

	}

}
