package com.psp.ejercicio5;

class CuentaPares2 implements Runnable{
	Contador2 cont = new Contador2();
	private int rango;
	private int cuenta;

	CuentaPares2(int rango, Contador2 c) {
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

