package com.psp.ejercicio3;

public class CuentaPares implements Runnable{
	Contador cont = new Contador();

	@Override
	public void run() {		
		for (int i = 1; i <= 200; i++) {
			if (i % 2 == 0) {
				cont.incrementaPares();
				System.out.println(i+" es par");
			}
		}
	}
}