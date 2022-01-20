package com.psp.ejercicio5;

import java.util.Date;

public class Main {
	public static void main(String[] args) {
		Contador c = new Contador();
		int x = 1;
		int y = 100000000;
		long t0 = (new Date()).getTime();	
		int nHilos= 100;
		Thread[] hilos = new Thread[nHilos];
		
		for (int i = 0; i < nHilos; i++) {
			Thread hilo = new Thread(new CuentaPares(y/nHilos, c));
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
		System.out.println("Número de pares en el intervalo: "+x+" - "+y+" es igual a "+ c.getCuenta() +" calculado en "+time+ " milisegundos");
	}
}

class CuentaPares implements Runnable{
	Contador cont = new Contador();
	private int rango;
	private int cuenta;

	CuentaPares(int rango, Contador c) {
	    this.rango = rango;
	    this.cont = c;
	  }
	
	public int getCuenta() {
		return cuenta;
	}

	@Override
	public void run() {		
		for (int i = 1; i <= rango; i++) {
			if (i % 2 == 0) {
				cont.incrementa();
				System.out.println(i+" es par");
				cuenta++;
			}
		}
		System.out.println("El hilo " + Thread.currentThread().getName() + " ha contado "+ getCuenta() + " numeros pares.");
	}
}
