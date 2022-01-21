package com.psp.ejercicio5;

import java.util.Date;

public class Main {
	public static void main(String[] args) {
		Contador contador = new Contador();
		int x = 1;
		int y = 1000;
		long t0 = (new Date()).getTime();	
		int nHilos= 10;
		Thread[] hilos = new Thread[nHilos];
		
		for (int i = 0; i < nHilos; i++) {
			Thread hilo = new Thread(new CuentaPares(y/nHilos, contador));
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
		System.out.println("Número de pares en el intervalo: "+x+" - "+y+" es igual a "+ contador.getCuenta() +" calculado en "+time+ " milisegundos");
	}
}
