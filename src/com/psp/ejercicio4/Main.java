package com.psp.ejercicio4;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.psp.ejercicio3.Contador;
import com.psp.ejercicio3.CuentaPares;

public class Main {
	public static void main(String[] args) {
		Contador cont = new Contador();
		int x = 1;
		int y = 100000000;
		long t0 = (new Date()).getTime();
		int nHilos= 20;
		
		ExecutorService executorService = Executors.newFixedThreadPool(nHilos);  
		
		CuentaPares hilo1= new CuentaPares(1, 10000000, cont);
		CuentaPares hilo2= new CuentaPares(10000001, 20000000, cont);
		CuentaPares hilo3= new CuentaPares(20000001, 30000000, cont);
		CuentaPares hilo4= new CuentaPares(30000001, 40000000, cont);
		CuentaPares hilo5= new CuentaPares(40000001, 50000000, cont);
		CuentaPares hilo6= new CuentaPares(50000001, 60000000, cont);
		CuentaPares hilo7= new CuentaPares(60000001, 70000000, cont);
		CuentaPares hilo8= new CuentaPares(70000001, 80000000, cont);
		CuentaPares hilo9= new CuentaPares(80000001, 90000000, cont);
		CuentaPares hilo10= new CuentaPares(90000001, 100000000, cont);
		
		executorService.execute(hilo1);
		executorService.execute(hilo2);
		executorService.execute(hilo3);
		executorService.execute(hilo4);
		executorService.execute(hilo5);
		executorService.execute(hilo6);
		executorService.execute(hilo7);
		executorService.execute(hilo8);
		executorService.execute(hilo9);
		executorService.execute(hilo10);
		
		executorService.shutdown();
		
		while (!executorService.isTerminated()) {
        }
		
		long t1 = (new Date()).getTime();
		long time = t1 - t0;
		System.out.println("Número de pares en el intervalo: "+x+" - "+y+" es igual a "+ cont.getCuenta() +" calculado en "+time+ " milisegundos");

	}
}
