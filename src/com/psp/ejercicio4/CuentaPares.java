package com.psp.ejercicio4;

public class CuentaPares implements Runnable{
	Contador cont = new Contador();
	
	@Override
	public void run() {		
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				cont.incrementaPares();
				System.out.println(i+" es par");
			}
		}
	}
}