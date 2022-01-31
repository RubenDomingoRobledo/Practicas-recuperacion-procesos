package com.psp.ejercicio5;

import java.util.Date;

public class Main {
	public static void main(String[] args) {
		Contador contador = new Contador();
		Contador2 contador2 = new Contador2();
		
		int x = 1;
		int y = 1000000;
		long t0 = (new Date()).getTime();	
		int nHilos= 5;
		Thread[] hilos = new Thread[nHilos];
		for (int i = 0; i < nHilos; i++) {
			Thread hilo = new Thread(new CuentaPares(1,y/nHilos, contador));
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
		System.out.println("------------------------\n");

		for (int i = 0; i < nHilos; i++) {
			Thread hilo = new Thread(new CuentaPares2(1,y/nHilos, contador2));
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
			
		long t2 = (new Date()).getTime();
		long time2 = t2 - t0;
		System.out.println("Número de pares en el intervalo: "+x+" - "+y+" es igual a "+ contador2.getCuenta() +" calculado en "+time2+ " milisegundos");
	}
}
