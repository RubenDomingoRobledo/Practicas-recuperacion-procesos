package com.psp.ejercicio3;

import java.util.Date;

public class Main {
	public static void main(String[] args) {
		int x = 1;
		int y = 100000000;
		long t0 = (new Date()).getTime();
		int nHilos= 5;
		Thread[] hilos = new Thread[nHilos];
		CuentaPares cp = new CuentaPares();
		
		for (int i = 0; i < nHilos; i++) {
			Thread hilo = new Thread(cp);
		    hilo.start();
		    hilos[i] = hilo;
		}
		
		for (Thread hilo: hilos) {
			try {
				hilo.join();
		    } 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		long t1 = (new Date()).getTime();
		long time = t1 - t0;
		System.out.println("Número de pares en el intervalo: "+x+" - "+y+" es igual a "+ cp.cont.getCuenta() +" calculado en "+time+ " milisegundos");
	}
}
