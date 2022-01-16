package com.psp.ejercicio4;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		int x = 1;
		int y = 100;
		long t0 = (new Date()).getTime();
		long t1 = (new Date()).getTime();
		long time = t1 - t0;
		CuentaPares cp = new CuentaPares();
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i =0; i<20; i++) {
			executor.execute(cp);
		}
		executor.shutdown();	
		
		if (executor.isShutdown()==true) {
			System.out.println("Número de pares en el intervalo: "+x+" - "+y+" es igual a "+ cp.cont.getCuenta() +" calculado en "+time+ " milisegundos");
		}
	}
}
