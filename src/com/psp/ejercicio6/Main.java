package com.psp.ejercicio6;

import java.util.Date;

public class Main {
	public static void main(String[] args) {
		int x = 1;
		int y = 2000;
		long t0 = (new Date()).getTime();
		Contador c = new Contador();
		
		CuentaPares cp = new CuentaPares(c);
		DeterminaPar dp = new DeterminaPar();
	
		Thread hilo1 = new Thread(cp);
		Thread hilo2 = new Thread(dp);
		Thread hilo3 = new Thread(cp);
		Thread hilo4 = new Thread(dp);

		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();

		try {
			hilo1.join();
			hilo2.join();
			hilo3.join();
			hilo4.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long t1 = (new Date()).getTime();
		long time = t1 - t0;
		System.out.println("Número de pares en el intervalo: "+x+" - "+y+" es igual a " + cp.cont.getCuenta() + " calculado en "+time+ " milisegundos");
	}
}
