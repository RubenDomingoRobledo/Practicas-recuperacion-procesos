package com.psp.ejercicio3;

public class CuentaPares implements Runnable{
	Contador cont = new Contador();
	private int inicio;
	private int fin;

	public CuentaPares(int inicio, int fin, Contador cont) {
		this.inicio= inicio;
		this.fin= fin;
		this.cont= cont;
	}

	@Override
	public void run() {		
		for (int i = inicio; i <= fin; i++) {
			if (i % 2 == 0) {
				cont.incrementaPares();
				System.out.println(i+" es par");
			}
		}
	}
}