package com.psp.ejercicio5;

class CuentaPares implements Runnable{
	Contador cont = new Contador();
	private int rango;
	private int cuenta;

	CuentaPares(int rango, Contador c) {
	    this.rango = rango;
	    this.cont = c;
	  }
	
	public int getCuenta() {
		return cuenta;
	}

	@Override
	public void run() {		
		for (int i = 1; i <= rango; i++) {
			if (i % 2 == 0) {
				cont.incrementa();
				System.out.println(i+" es par");
				cuenta++;
			}
		}
		System.out.println("El hilo " + Thread.currentThread().getName() + " ha contado "+ getCuenta() + " numeros pares.");
	}
}

