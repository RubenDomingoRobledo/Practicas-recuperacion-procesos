package com.psp.ejercicio6;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		int x = 1;
		int y = 2000;
		long t0 = (new Date()).getTime();
		Contador contador = new Contador();
		List<Integer> listaPares = new ArrayList<Integer>();
		
		CuentaPares cp = new CuentaPares(listaPares, contador);
		DeterminaPar dp = new DeterminaPar(listaPares);
	
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
		System.out.println("Número de pares en el intervalo: "+x+" - "+y+" es igual a " + contador.getCuenta() + " calculado en "+time+ " milisegundos");
	}
}
