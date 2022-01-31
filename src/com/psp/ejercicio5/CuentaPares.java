package com.psp.ejercicio5;

class CuentaPares implements Runnable{
	Contador cont = new Contador();
	private int inicio;
	private int fin;
	private int cuenta;

	public CuentaPares(int inicio, int fin, Contador cont) {
		this.inicio= inicio;
		this.fin= fin;
		this.cont= cont;
	}
	
	public int getCuenta() {
		return cuenta;
	}

	@Override
	public void run() {		
		for (int i = inicio; i <= fin; i++) {
			if (i % 2 == 0) {
				cont.incrementa();
				System.out.println(i+" es par");
				cuenta++;
			}
		}
		System.out.println("El hilo " + Thread.currentThread().getName() + " ha contado "+ getCuenta() + " numeros pares.");
	}
}

