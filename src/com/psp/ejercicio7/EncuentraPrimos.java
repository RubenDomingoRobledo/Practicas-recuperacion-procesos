package com.psp.ejercicio7;

import java.util.Date;

public class EncuentraPrimos {

	public static void main(String[] args) {
		Contador cont = new Contador();
		long t0 = (new Date()).getTime();
		Thread hilo1 = new Thread(new Primos(1, 2000, cont));
		Thread hilo2 = new Thread(new Primos(2001, 4000, cont));
		Thread hilo3 = new Thread(new Primos(4001, 6000, cont));
		Thread hilo4 = new Thread(new Primos(6001, 8000, cont));
		Thread hilo5 = new Thread(new Primos(8001, 10000, cont));

		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();
		
		try {
			hilo1.join();
			hilo2.join();
			hilo3.join();
			hilo4.join();
			hilo5.join();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		long t5 = (new Date()).getTime();
		long time5 = t5 - t0;
		
		System.out.println("Número de primos entre 1 y 10000000: " + cont.getCuenta() + " calculado en " + time5 + " milisegundos");

	}

}
