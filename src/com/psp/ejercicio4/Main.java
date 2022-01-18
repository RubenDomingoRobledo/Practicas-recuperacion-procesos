package com.psp.ejercicio4;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		int x = 1;
		int y = 1000;
		long t0 = (new Date()).getTime();
		int nHilos= 20;
		
		ExecutorService executorService = Executors.newFixedThreadPool(nHilos);  
		CuentaPares cp = new CuentaPares();
		
		for (int i = 0; i < 10; i++) {
    		executorService.execute(cp); 
    	} 
        executorService.shutdown();

		
		long t1 = (new Date()).getTime();
		long time = t1 - t0;
		System.out.println("Número de pares en el intervalo: "+x+" - "+y+" es igual a "+ cp.cont.getCuenta() +" calculado en "+time+ " milisegundos");
	}
}
