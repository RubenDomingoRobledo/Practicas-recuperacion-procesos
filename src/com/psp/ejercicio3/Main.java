package com.psp.ejercicio3;

import java.util.Date;

public class Main {
	public static void main(String[] args) {
		Contador cont = new Contador();
		int x = 1;
		int y = 100000000;
		long t0 = (new Date()).getTime();
		
		Thread hilo1 = new Thread(new CuentaPares(1, 20000000, cont));
		Thread hilo2 = new Thread(new CuentaPares(20000001, 40000000, cont));
		Thread hilo3 = new Thread(new CuentaPares(40000001, 60000000, cont));
		Thread hilo4 = new Thread(new CuentaPares(60000001, 80000000, cont));
		Thread hilo5 = new Thread(new CuentaPares(80000001, 100000000, cont));
		
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
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long t1 = (new Date()).getTime();
		long time = t1 - t0;
		System.out.println("Número de pares en el intervalo: "+x+" - "+y+" es igual a "+ cont.getCuenta() +" calculado en "+time+ " milisegundos");
	}
}
